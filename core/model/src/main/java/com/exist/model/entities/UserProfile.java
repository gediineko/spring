package com.exist.model.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ggolong on 8/25/16.
 */
@Entity
public class UserProfile extends UserAccount {
    private static final long serialVersionUID = -3138466364444175632L;

    @Embedded
    private Name name;

    @Embedded
    private Address address;

    @Column
    private Date birthDate;

    @Column
    private Double gwa;

    @Column
    private Date dateHired;

    @Column
    private Boolean currentlyEmployed;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contactInfo = new ArrayList<>();


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Double getGwa() {
        return gwa;
    }

    public void setGwa(Double gwa) {
        this.gwa = gwa;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public Boolean getCurrentlyEmployed() {
        return currentlyEmployed;
    }

    public void setCurrentlyEmployed(Boolean currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }

    public List<Contact> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(List<Contact> contactInfo) {
        this.contactInfo = contactInfo;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("address", address)
                .append("birthDate", birthDate)
                .append("gwa", gwa)
                .append("dateHired", dateHired)
                .append("currentlyEmployed", currentlyEmployed)
                .toString();
    }

}
