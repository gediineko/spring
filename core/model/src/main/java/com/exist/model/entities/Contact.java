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
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Column
    private String contactInfo;

    @Column
    private String contactType;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
