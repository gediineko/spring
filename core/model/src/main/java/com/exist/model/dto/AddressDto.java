package com.exist.model.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by ggolong on 8/26/16.
 */
public class AddressDto {
    private String streetNumber;
    private String barangay;
    private String city;
    private String zipCode;

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
                .append("streetNumber", streetNumber)
                .append("barangay", barangay)
                .append("city", city)
                .append("zipCode", zipCode)
                .toString();
    }

}
