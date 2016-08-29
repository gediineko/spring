package com.exist.model.dto;

import com.opencsv.bean.CsvBind;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by jvillanueva on 8/29/16.
 */
public class CSVRowDto {

    @CsvBind
    private long id;

    @CsvBind
    private String username;
    @CsvBind
    private String newPassword;

    @CsvBind
    private String title;
    @CsvBind
    private String firstName;
    @CsvBind
    private String middleName;
    @CsvBind
    private String lastName;
    @CsvBind
    private String suffix;


    @CsvBind
    private String birthDate;
    @CsvBind
    private double gwa;
    @CsvBind
    private String dateHired;
    @CsvBind
    private boolean currentlyEmployed;

    @CsvBind
    private String streetNumber;
    @CsvBind
    private String barangay;
    @CsvBind
    private String city;
    @CsvBind
    private String zipCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public double getGwa() {
        return gwa;
    }

    public void setGwa(double gwa) {
        this.gwa = gwa;
    }

    public String getDateHired() {
        return dateHired;
    }

    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }

    public boolean isCurrentlyEmployed() {
        return currentlyEmployed;
    }

    public void setCurrentlyEmployed(boolean currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("username", username)
                .append("newPassword", newPassword)
                .append("title", title)
                .append("firstName", firstName)
                .append("middleName", middleName)
                .append("lastName", lastName)
                .append("suffix", suffix)
                .append("birthDate", birthDate)
                .append("gwa", gwa)
                .append("dateHired", dateHired)
                .append("currentlyEmployed", currentlyEmployed)
                .append("streetNumber", streetNumber)
                .append("barangay", barangay)
                .append("city", city)
                .append("zipCode", zipCode)
                .toString();
    }
}
