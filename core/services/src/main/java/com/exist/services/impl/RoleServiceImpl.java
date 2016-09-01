package com.exist.services.impl;

import com.exist.model.dto.RoleDto;
import com.exist.repositories.jpa.RoleRepository;
import com.exist.services.RoleService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by ggolong on 8/26/16.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public Set<RoleDto> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(r -> mapper.map(r, RoleDto.class))
                .collect(Collectors.toSet());
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
    public void delete(Long roleId) {

    }
}
