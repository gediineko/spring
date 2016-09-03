package com.exist.services;

import com.exist.model.dto.RoleDto;
import com.exist.model.exception.EntityAlreadyExistsException;
import com.exist.model.exception.EntityDoesNotExistException;
import com.exist.model.ref.RoleType;

import java.util.Set;

/**
 * Created by ggolong on 8/26/16.
 */
public interface RoleService {
    Set<RoleDto> getAll();
    Set<RoleDto> getAllByType(RoleType roleType);
    RoleDto create(RoleDto roleDto) throws EntityAlreadyExistsException;
    RoleDto update(RoleDto roleDto) throws EntityDoesNotExistException;
    void delete(Long roleId) throws EntityDoesNotExistException;
}
