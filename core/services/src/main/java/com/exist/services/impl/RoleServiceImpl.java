package com.exist.services.impl;

import com.exist.model.dto.RoleDto;
import com.exist.repositories.jpa.RoleRepository;
import com.exist.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;

/**
 * Created by ggolong on 8/26/16.
 */
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Set<RoleDto> getAll() {
        return null;
    }

    @Override
    public RoleDto create() {
        return null;
    }

    @Override
    public RoleDto update() {
        return null;
    }

    @Override
    public void delete() {

    }
}
