package com.exist.repositories.jpa;

import com.exist.model.entities.Role;
import com.exist.model.ref.RoleType;
import com.exist.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by ggolong on 8/26/16.
 */
@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {

    Optional<Role> findByName(String name);

    List<Role> findByRoleType(RoleType roleType);
}
