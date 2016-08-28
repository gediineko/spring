package com.exist.model.dto;

import com.exist.model.base.BaseDto;

/**
 * Created by ggolong on 8/26/16.
 */
public class ContactDto extends BaseDto {
    private String contactInfo;
    private String contactType;

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
