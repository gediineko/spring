package com.exist.services;

import com.exist.model.dto.UserAccountDto;
import com.exist.model.exception.EntityDoesNotExistException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserAccountService extends UserDetailsService {

    UserAccountDto get(Long id) throws EntityDoesNotExistException;

    List<UserAccountDto> getAll();

    UserAccountDto create(UserAccountDto userAccountDto);

    UserAccountDto update(UserAccountDto userAccountDto);

    void uploadUsers(MultipartFile file) throws IOException;

    void delete(Long userAccountId) throws EntityDoesNotExistException;
}
