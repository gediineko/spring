package com.exist.repositories.jpa;

import com.exist.model.entities.UserAccount;
import com.exist.model.ref.RoleType;
import com.exist.repositories.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends BaseRepository<UserAccount, Long> {
    Optional<UserAccount> findByUsername(String s);

    @Query("select distinct u from UserAccount u inner join u.roles r where r.roleType = :roleType")
    List<UserAccount> findByRoleType(@Param("roleType") RoleType roleType);
}
