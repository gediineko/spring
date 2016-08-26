package com.exist.repositories.jpa;

import com.exist.model.entities.UserProfile;
import com.exist.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ggolong on 8/26/16.
 */
@Repository
public interface UserProfileRepository extends BaseRepository<UserProfile, Long> {
}
