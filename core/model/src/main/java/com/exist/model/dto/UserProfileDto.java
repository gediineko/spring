package com.exist.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ggolong on 8/26/16.
 */
public class UserProfileDto extends UserAccountDto {
    private NameDto name;
    private AddressDto address;
    private Date birthDate;
    private Double gwa;
    private Date dateHired;
    private Boolean currentlyEmployed;
    private List<ContactDto> contactInfo = new ArrayList<>();

    public NameDto getName() {
        return name;
    }

    public void setName(NameDto name) {
        this.name = name;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
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

    public List<ContactDto> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(List<ContactDto> contactInfo) {
        this.contactInfo = contactInfo;
    }
}
