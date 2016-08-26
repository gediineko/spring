package com.exist.model.dto;

import com.exist.model.base.BaseDto;
import com.exist.model.ref.RoleType;

/**
 * Created by ggolong on 8/26/16.
 */
public class RoleDto extends BaseDto {
    private String name;
    private RoleType roleType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
