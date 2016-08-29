package com.exist.services.impl;

import com.exist.model.dto.CSVRowDto;
import com.exist.model.dto.UserAccountDto;
import com.exist.model.dto.UserProfileDto;
import com.exist.model.entities.UserAccount;
import com.exist.model.ref.RoleType;
import com.exist.repositories.jpa.UserAccountRepository;
import com.exist.services.UserAccountService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    @Transactional(readOnly = true)
    public UserAccount loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserAccount> userAccount = userAccountRepository.findByUsername(s);
        if (!userAccount.isPresent()) {
            return null;
        }
        return userAccount.get();
    }


    @Override
    @Transactional(readOnly = true)
    public UserAccountDto get(Long id) {
        Optional<UserAccount> userAccount = Optional.of(userAccountRepository.findOne(id));
        if (!userAccount.isPresent()) {
            return null;
        }
        return mapper.map(userAccount.get(), UserAccountDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserAccountDto> getAll() {
        return userAccountRepository.findByRoleType(RoleType.ADMIN)
                .stream()
                .map(u -> mapper.map(u, UserAccountDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserAccountDto create(UserAccountDto userAccountDto) {

        Optional<UserAccount> existingUser = userAccountRepository.findByUsername(userAccountDto.getUsername());
        if(existingUser.isPresent()){
            throw new IllegalArgumentException("User already exists");
        }

        UserAccount newUserAccount = new UserAccount();
        mapper.map(userAccountDto, newUserAccount);

        newUserAccount.setId(null);
        newUserAccount.setUsername(userAccountDto.getUsername());
        newUserAccount.setPassword(passwordEncoder.encode(userAccountDto.getNewPassword()));

        return mapper.map(userAccountRepository.save(newUserAccount), UserAccountDto.class);
    }

    @Override
    public UserAccountDto update(UserAccountDto userAccountDto) {
        Optional<UserAccount> existingUserOptl = Optional.of(userAccountRepository.getOne(userAccountDto.getId()));
        if(!existingUserOptl.isPresent()){
            throw new IllegalArgumentException("User does not exists");
        }
        UserAccount existingUser = existingUserOptl.get();
        mapper.map(userAccountDto, existingUser);

        if(!existingUser.getPassword().equals(userAccountDto.getNewPassword())){
            existingUser.setPassword(passwordEncoder.encode(userAccountDto.getNewPassword()));
        }

        return mapper.map(userAccountRepository.save(existingUser), UserAccountDto.class);
    }

    @Override
    public void uploadUsers(MultipartFile file) throws IOException {
        // tells that mapping will be based on column, the first line of your csv file
        HeaderColumnNameMappingStrategy<CSVRowDto> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(CSVRowDto.class);

        //instantiated the csv to bean
        CsvToBean<CSVRowDto> csvToBean = new CsvToBean<>();
        //parsed the ccsv fows to list of csvRowsDto
        List<CSVRowDto> csvRowDtos = csvToBean.parse(strategy, new InputStreamReader(file.getInputStream()));

        csvRowDtos.stream()
                .map(row -> mapper.map(row, UserProfileDto.class))
                .forEach(System.out::println);
        // At this point you can forEach the mapped UserProfileDto
        // to check if its exising or not (with or without id
        // and  persistent entity via repo.findOne()
        // then map it from dto to entity then save
        // this can handle both update and create
    }
}
