package com.exist.model.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ggolong on 8/26/16.
 */
public class UserProfileDto extends UserAccountDto {
    private NameDto name;

    private AddressDto address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private Double gwa;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("address", address)
                .append("birthDate", birthDate)
                .append("gwa", gwa)
                .append("dateHired", dateHired)
                .append("currentlyEmployed", currentlyEmployed)
                .append("contactInfo", contactInfo)
                .toString();
    }
}
