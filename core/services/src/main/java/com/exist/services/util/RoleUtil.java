package com.exist.services.util;

import com.exist.model.entities.Role;
import com.exist.model.ref.RoleType;

import java.util.Set;

/**
 * Created by jvillanueva on 8/27/16.
 */
public class RoleUtil {
    public static boolean isAdmin (Set<Role> roles){
        return roles.stream()
                .map(Role::getRoleType)
                .anyMatch(r -> r.equals(RoleType.ADMIN));

    }
}
