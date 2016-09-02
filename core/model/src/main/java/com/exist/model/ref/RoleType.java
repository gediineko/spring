package com.exist.model.ref;

public enum RoleType {
    ADMIN("Admin"),
    USER("User");

    private String desc;

    RoleType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
