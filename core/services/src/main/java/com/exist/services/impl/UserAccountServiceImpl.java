package com.exist.services.impl;

import com.exist.model.entities.UserAccount;
import com.exist.repositories.jpa.UserAccountRepository;
import com.exist.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserAccount> userAccount = Optional.of(userAccountRepository.findByUsername(s));
        if (!userAccount.isPresent()) {
            return null;
        }
        return userAccount.get();
    }
}
