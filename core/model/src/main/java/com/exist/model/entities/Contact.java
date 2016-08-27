package com.exist.model.entities;

import com.exist.model.base.BaseEntity;

import javax.persistence.*;

/**
 * Created by ggolong on 8/25/16.
 */
@Entity
public class Contact extends BaseEntity {

    private static final long serialVersionUID = -1772785729825786403L;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "USERPROFILE_ID")
    private UserProfile userProfile;

    @Column
    private String contactInfo;

    @Column
    private String contactType;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
}
