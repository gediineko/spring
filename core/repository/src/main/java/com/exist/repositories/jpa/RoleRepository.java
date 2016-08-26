package com.exist.repositories.jpa;

import com.exist.model.entities.Role;
import com.exist.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ggolong on 8/26/16.
 */
@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {
}
