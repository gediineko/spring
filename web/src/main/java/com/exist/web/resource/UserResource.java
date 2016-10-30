package com.exist.web.resource;

import com.exist.model.dto.UserProfileDto;
import com.exist.model.exception.EntityAlreadyExistsException;
import com.exist.model.exception.EntityDoesNotExistException;
import com.exist.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ggolong on 10/29/16.
 */

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping
    public ResponseEntity<List<UserProfileDto>> getAll() {
        String sortProp = "lastName";
        String sortDir = "asc";
        return ResponseEntity.ok(userProfileService.getAll(sortProp, sortDir));
    }

    @GetMapping("api/user/{userId}")
    public ResponseEntity<UserProfileDto> get(@PathVariable Long userId)
            throws EntityDoesNotExistException {
        return ResponseEntity.ok(userProfileService.get(userId));
    }

    @PostMapping
    public ResponseEntity<UserProfileDto> create(UserProfileDto userProfileDto)
            throws EntityAlreadyExistsException {

    }
}
