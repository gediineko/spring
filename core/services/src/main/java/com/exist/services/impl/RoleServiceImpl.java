package com.exist.services.impl;

import com.exist.services.RoleService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by ggolong on 8/26/16.
 */
public class RoleServiceImpl implements RoleService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
