package com.exist.services.impl;

import com.exist.model.dto.CSVRowDto;
import com.exist.model.dto.ContactDto;
import com.exist.model.dto.UserProfileDto;
import com.exist.model.entities.Contact;
import com.exist.model.entities.UserProfile;
import com.exist.model.exception.EntityAlreadyExistsException;
import com.exist.model.exception.EntityDoesNotExistException;
import com.exist.repositories.jpa.ContactRepository;
import com.exist.repositories.jpa.UserProfileRepository;
import com.exist.services.UserProfileService;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ggolong on 8/26/16.
 */
@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private Mapper mapper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserProfileDto> getAll(String sortProp, String sortDir) {
        return userProfileRepository.findAll()
                .stream()
                .map(u -> mapper.map(u, UserProfileDto.class))
                .sorted((u1, u2) -> {
                    if (StringUtils.isNotBlank(sortProp) && StringUtils.isNotBlank(sortDir)) {
                        switch (sortProp) {
                            case "gwa":
                                return Double.compare(u1.getGwa(), u2.getGwa()) * (sortDir.equals("asc") ? 1 : -1);
                            case "dateHired":
                                return u1.getDateHired().compareTo(u2.getDateHired()) * (sortDir.equals("asc") ? 1 : -1);
                            case "lastName":
                                return u1.getName().getLastName().compareTo(u2.getName().getLastName()) * (sortDir.equals("asc") ? 1 : -1);
                        }
                    }
                    return Long.compare(u1.getId(), u2.getId());
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserProfileDto update(UserProfileDto userProfileDto) throws EntityAlreadyExistsException {

        UserProfile existingUser = Optional.ofNullable(userProfileRepository.getOne(userProfileDto.getId()))
                .orElseThrow(() -> new EntityAlreadyExistsException(
                        "User with that ID Does not exist: " + userProfileDto.getId(),
                        "error.user.notExists",
                        new Object[]{userProfileDto.getId()}));

        mapper.map(userProfileDto, existingUser);

        if(StringUtils.isNotBlank(userProfileDto.getNewPassword()) && !existingUser.getPassword().equals(userProfileDto.getNewPassword())){
            existingUser.setPassword(passwordEncoder.encode(userProfileDto.getNewPassword()));
        }
        return mapper.map(userProfileRepository.save(existingUser), UserProfileDto.class);
    }

    @Override
    public UserProfileDto create(UserProfileDto userProfileDto) throws EntityAlreadyExistsException {

        Optional<UserProfile> existingUser = userProfileRepository.findByUsername(userProfileDto.getUsername());
        if(existingUser.isPresent()){
            throw new EntityAlreadyExistsException(
                    "User with that username already exists: " + userProfileDto.getUsername(),
                    "error.user.exists",
                    new Object[]{userProfileDto.getUsername()});
        }

        UserProfile newUserProfile = new UserProfile();
        mapper.map(userProfileDto, newUserProfile);

        newUserProfile.setId(null);
        newUserProfile.setUsername(userProfileDto.getUsername());
        newUserProfile.setPassword(passwordEncoder.encode(userProfileDto.getNewPassword()));

        return mapper.map(userProfileRepository.save(newUserProfile), UserProfileDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public UserProfileDto get(Long userId) throws EntityDoesNotExistException {
        UserProfile userProfile = Optional.ofNullable(userProfileRepository.findOne(userId))
                .orElseThrow(() -> new EntityDoesNotExistException(
                        "User with that ID does not exist: " + userId,
                        "error.user.notExists",
                        new Object[]{userId}));
        userProfile.setContactInfo(userProfile.getContactInfo());
        return mapper.map(userProfile, UserProfileDto.class);
    }

    @Override
    public void addContact(Long userId, ContactDto contactDto) {
        UserProfile user = userProfileRepository.findOne(userId);
        Contact contact = mapper.map(contactDto, Contact.class);
        if (user != null){
            contact.setUserProfile(user);
            user.getContactInfo().add(contact);
        }
    }

    @Override
    public void removeContact(Long userId, Long contactId) {
        UserProfile user = userProfileRepository.findOne(userId);
        Contact contact = contactRepository.findOne(contactId);
        if (user != null && contact != null) {
            user.getContactInfo().remove(contact);
            userProfileRepository.save(user);
        }


    }

    @Override
    public void updateContact(ContactDto contactDto) {
        Contact contact = contactRepository.findOne(contactDto.getId());
        if (contact != null) {
            mapper.map(contactDto, contact);
            contactRepository.save(contact);
        }
    }

    @Override
    public void delete(Long userId) {
        UserProfile user = userProfileRepository.findOne(userId);
        if(user != null){
            userProfileRepository.delete(user);
        }
    }

    @Override
    public CSVRowDto getUpdateFormData(Long userId) throws EntityDoesNotExistException {
        UserProfileDto userProfileDto = get(userId);
        return mapper.map(userProfileDto, CSVRowDto.class);
    }

    @Override
    public UserProfileDto uploadForm(CSVRowDto csvRowDto) throws EntityAlreadyExistsException {
        UserProfileDto userProfileDto = mapper.map(csvRowDto, UserProfileDto.class);

        return update(userProfileDto);
    }

}
