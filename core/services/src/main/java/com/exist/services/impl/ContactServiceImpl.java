package com.exist.services.impl;

import com.exist.services.ContactService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by ggolong on 8/26/16.
 */
public class ContactServiceImpl implements ContactService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
