package com.exist.services;

import com.exist.model.dto.RoleDto;
import com.exist.model.exception.EntityAlreadyExistsException;

import java.util.Set;

/**
 * Created by ggolong on 8/26/16.
 */
public interface RoleService {
    Set<RoleDto> getAll();
    RoleDto create(RoleDto roleDto) throws EntityAlreadyExistsException;
    RoleDto update(RoleDto roleDto) throws EntityAlreadyExistsException;
    void delete(Long roleId) throws EntityAlreadyExistsException;
}
