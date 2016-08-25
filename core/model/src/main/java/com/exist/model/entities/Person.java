package com.exist.model.entities;

import com.exist.model.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.*;

/**
 * Created by ggolong on 8/25/16.
 */
@Entity
public class Person extends BaseEntity {
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PERSON_ROLE",
            joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
