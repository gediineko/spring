package com.exist.services;

import com.exist.model.dto.UserAccountDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserAccountService extends UserDetailsService {

    UserAccountDto get(Long id);

    List<UserAccountDto> getAll();

    UserAccountDto create(UserAccountDto userAccountDto);

    UserAccountDto update(UserAccountDto userAccountDto);
}
