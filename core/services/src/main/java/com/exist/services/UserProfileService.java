package com.exist.services;

import com.exist.model.dto.CSVRowDto;
import com.exist.model.dto.ContactDto;
import com.exist.model.dto.UserProfileDto;
import com.exist.model.exception.EntityAlreadyExistsException;
import com.exist.model.exception.EntityDoesNotExistException;

import java.util.List;

/**
 * Created by ggolong on 8/26/16.
 */
public interface UserProfileService {

    List<UserProfileDto> getAll(String sortProp, String sortDir);

    UserProfileDto update(UserProfileDto userProfileDto) throws EntityAlreadyExistsException;

    UserProfileDto create(UserProfileDto userProfileDto) throws EntityAlreadyExistsException;

    UserProfileDto get(Long userId) throws EntityDoesNotExistException;

    void addContact(Long userId, ContactDto contact);

    void removeContact(Long userId, Long contactId);

    void updateContact(ContactDto contactDto);

    void delete(Long userId);

    CSVRowDto getUpdateFormData(Long userId) throws EntityDoesNotExistException;

    UserProfileDto uploadForm(CSVRowDto csvRowDto) throws EntityAlreadyExistsException;
}
