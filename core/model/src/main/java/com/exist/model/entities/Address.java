package com.exist.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by ggolong on 8/25/16.
 */
@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = 8225560922213682364L;

    @Column
    private String streetNumber;

    @Column
    private String barangay;

    @Column
    private String city;

    @Column
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
}
