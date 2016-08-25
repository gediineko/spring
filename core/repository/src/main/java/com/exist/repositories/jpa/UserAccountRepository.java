package com.exist.repositories.jpa;

import com.exist.model.entities.UserAccount;
import com.exist.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends BaseRepository<UserAccount, Long> {
    UserAccount findByUsername(String s);
}
