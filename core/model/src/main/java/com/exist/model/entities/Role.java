package com.exist.model.entities;

import com.exist.model.base.BaseEntity;
import com.exist.model.ref.RoleType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1068681731270573784L;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "JOIN_USER_ACCOUNT_X_ROLE",
            joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ACCOUNT_ID"))
    private List<UserAccount> userAccounts;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
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

    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(name, role1.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(name)
                .toHashCode();
    }
}
