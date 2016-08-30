package com.exist.model.dto;

import com.exist.model.base.BaseDto;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("contactInfo", contactInfo)
                .append("contactType", contactType)
                .toString();
    }
}
