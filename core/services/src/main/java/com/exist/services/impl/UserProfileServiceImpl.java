package com.exist.services.impl;

import com.exist.model.dto.ContactDto;
import com.exist.model.dto.UserProfileDto;
import com.exist.model.entities.Contact;
import com.exist.model.entities.UserProfile;
import com.exist.model.exception.EntityDoesNotExistException;
import com.exist.repositories.jpa.ContactRepository;
import com.exist.repositories.jpa.UserProfileRepository;
import com.exist.services.UserProfileService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<UserProfileDto> getAll() {
        return userProfileRepository.findAll()
                .stream()
                .map(u -> mapper.map(u, UserProfileDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserProfileDto> getAllByGwa() {
        return null;
    }

    @Override
    public List<UserProfileDto> getAllByDateHired() {
        return null;
    }

    @Override
    public List<UserProfileDto> getAllByLastName() {
        return null;
    }

    @Override
    public UserProfileDto update(UserProfileDto userProfileDto) {
        return null;
    }

    @Override
    public UserProfileDto create(UserProfileDto userProfileDto) {
        return null;
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
}
