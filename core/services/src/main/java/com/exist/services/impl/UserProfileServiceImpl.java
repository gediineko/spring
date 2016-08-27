package com.exist.services.impl;

import com.exist.model.dto.UserProfileDto;
import com.exist.model.entities.UserProfile;
import com.exist.repositories.jpa.UserProfileRepository;
import com.exist.services.UserProfileService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by ggolong on 8/26/16.
 */
@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<UserProfileDto> getAll() {
        return null;
    }

    @Override
    public UserProfileDto update(UserProfileDto userProfileDto) {
        return null;
    }

    @Override
    public UserProfileDto create(UserProfileDto userProfileDto) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public UserProfileDto get(Long userId) {
        Optional<UserProfile> userProfileOptl = Optional.ofNullable(userProfileRepository.findOne(userId));
        if(!userProfileOptl.isPresent()){
            throw new IllegalArgumentException("User does not exist");
        }
        UserProfile userProfile = userProfileOptl.get();
        userProfile.setContactInfo(userProfile.getContactInfo());
        return mapper.map(userProfileOptl.get(), UserProfileDto.class);
    }
}
