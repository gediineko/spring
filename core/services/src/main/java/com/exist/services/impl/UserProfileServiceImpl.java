package com.exist.services.impl;

import com.exist.services.UserProfileService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by ggolong on 8/26/16.
 */
public class UserProfileServiceImpl implements UserProfileService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
