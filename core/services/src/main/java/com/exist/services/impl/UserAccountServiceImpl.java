package com.exist.services.impl;

import com.exist.model.dto.UserAccountDto;
import com.exist.model.entities.UserAccount;
import com.exist.model.ref.RoleType;
import com.exist.repositories.jpa.UserAccountRepository;
import com.exist.services.UserAccountService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private Mapper mapper; // autowir ung dozer mapper na gnwan ng bean

    @Autowired
    private PasswordEncoder passwordEncoder; //autowire ung passwordecoder for apssword

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
        Optional<UserAccount> userAccount = Optional.of(userAccountRepository.findOne(id)); //find one is already implemented by JpaRepository/crud na inextedn ni baserepositroy
        if (!userAccount.isPresent()) {
            return null;
        }
        return mapper.map(userAccount.get(), UserAccountDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserAccountDto> getAll() {
        return userAccountRepository.findByRoleType(RoleType.ADMIN) // custom implementation via @Query
                .stream()
                .map(u -> mapper.map(u, UserAccountDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserAccountDto create(UserAccountDto userAccountDto) {
        //let's check if existing na ung username
        Optional<UserAccount> existingUser = userAccountRepository.findByUsername(userAccountDto.getUsername());
        if(existingUser.isPresent()){
            // If existing na ung user iwth that username, throw exception
            // ccustomize to dapat to a new exception pra mas specific
            // and this will be handled by controller advice
            throw new IllegalArgumentException("User already exists");
        }

        UserAccount newUserAccount = new UserAccount();
        //Map ung ibang fields
        mapper.map(userAccountDto, newUserAccount);

        //manually map ung critical fields
        newUserAccount.setId(null); //kpag create ,set this to null pra di magkaproblema kay hibernate na bka isipin existing na
        newUserAccount.setUsername(userAccountDto.getUsername());
        newUserAccount.setPassword(passwordEncoder.encode(userAccountDto.getNewPassword()));

        // ungsave ng jpaRepository retursn ung actual etntity na nasave kya rekta ko na dito
        return mapper.map(userAccountRepository.save(newUserAccount), UserAccountDto.class);
    }

    @Override
    public UserAccountDto update(UserAccountDto userAccountDto) {
        //let's check if exisintg ung ID bka kse hindi
        Optional<UserAccount> existingUserOptl = Optional.of(userAccountRepository.getOne(userAccountDto.getId()));
        //reverse naman natin ung logic ng if, mag tthrow sya ng exception kpag not exisitng
        if(!existingUserOptl.isPresent()){
            // If not exisintg with that id, throw exception
            // ccustomize to dapat to a new exception pra mas specific
            // and this will be handled by controller advice
            throw new IllegalArgumentException("User does not exists");
        }
        //Map ung ibang fields
        UserAccount existingUser = existingUserOptl.get();
        mapper.map(userAccountDto, existingUser);

        //manually map ung critical fields
        //checks if hindi equal ung exisitng password sa new password pra ma save ung password
        if(!existingUser.getPassword().equals(userAccountDto.getNewPassword())){
            existingUser.setPassword(passwordEncoder.encode(userAccountDto.getNewPassword()));
        }

        // ungsave ng jpaRepository retursn ung actual etntity na nasave kya rekta ko na dito
        return mapper.map(userAccountRepository.save(existingUser), UserAccountDto.class);
    }
}
