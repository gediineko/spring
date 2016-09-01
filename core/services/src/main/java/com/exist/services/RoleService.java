package com.exist.services;

import com.exist.model.dto.RoleDto;

import java.util.Set;

/**
 * Created by ggolong on 8/26/16.
 */
public interface RoleService {
    Set<RoleDto> getAll();
    RoleDto create();
    RoleDto update();
    void delete(Long roleId);
}
