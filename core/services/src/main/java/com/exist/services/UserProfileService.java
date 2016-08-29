package com.exist.services;

import com.exist.model.dto.ContactDto;
import com.exist.model.dto.UserProfileDto;

import java.util.List;

/**
 * Created by ggolong on 8/26/16.
 */
public interface UserProfileService {

    List<UserProfileDto> getAll();

    UserProfileDto update(UserProfileDto userProfileDto);

    UserProfileDto create(UserProfileDto userProfileDto);

    UserProfileDto get(Long userId);

    void addContact(Long userId, ContactDto contact);

    void removeContact(Long userId, Long contactId);

    void updateContact(ContactDto contactDto);


    void delete(Long userId);
}
