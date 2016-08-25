package com.exist.model.entities;

import com.exist.model.base.BaseEntity;
import com.exist.model.io.navillanueva.model.ref.RoleType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Role extends BaseEntity {

    @Column
    private String name;

    @Column
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
