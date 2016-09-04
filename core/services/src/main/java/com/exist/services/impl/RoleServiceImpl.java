package com.exist.services.impl;

import com.exist.model.dto.RoleDto;
import com.exist.model.entities.Role;
import com.exist.model.exception.EntityAlreadyExistsException;
import com.exist.model.exception.EntityDoesNotExistException;
import com.exist.model.ref.RoleType;
import com.exist.repositories.jpa.RoleRepository;
import com.exist.services.RoleService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by ggolong on 8/26/16.
 */
@Service
@Transactional
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
                .sorted((r1,r2) -> Long.compare(r1.getId(), r2.getId()))
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Set<RoleDto> getAllByType(RoleType roleType) {
        return roleRepository.findByRoleType(roleType)
                .stream()
                .map(r -> mapper.map(r, RoleDto.class))
                .sorted((r1,r2) -> Long.compare(r1.getId(), r2.getId()))
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public RoleDto create(RoleDto roleDto) throws EntityAlreadyExistsException {

        Optional<Role> existingRole = roleRepository.findByName(roleDto.getName());
        if(existingRole.isPresent()){
            throw new EntityAlreadyExistsException(
                    "Role with that name already exists: " + roleDto.getName(),
                    "error.role.exists",
                    new Object[]{roleDto.getName()});
        }

        Role newRole = new Role();
        mapper.map(roleDto, newRole);

        newRole.setId(null);

        return mapper.map(roleRepository.save(newRole), RoleDto.class);
    }

    @Override
    public RoleDto update(RoleDto roleDto) throws EntityDoesNotExistException {

        Role existingRole = Optional.ofNullable(roleRepository.getOne(roleDto.getId()))
                .orElseThrow(() -> new EntityDoesNotExistException(
                        "Role with ID Does not exist: " + roleDto.getId(),
                        "error.role.notExists",
                        new Object[]{roleDto.getId()}));

        mapper.map(roleDto, existingRole);

        return mapper.map(roleRepository.save(existingRole), RoleDto.class);
    }

    @Override
    public void delete(Long roleId) throws EntityDoesNotExistException {
        Role existingRole = Optional.ofNullable(roleRepository.getOne(roleId))
                .orElseThrow(() -> new EntityDoesNotExistException(
                        "Role with ID Does not exist: " + roleId,
                        "error.role.notExists",
                        new Object[]{roleId}));

        roleRepository.delete(existingRole);
    }
}
