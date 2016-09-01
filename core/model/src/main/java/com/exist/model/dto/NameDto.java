package com.exist.model.dto;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by ggolong on 8/26/16.
 */
public class NameDto {
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

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

    @Override
    public String toString() {
//        return new ToStringBuilder(this)
//                .append("title", title)
//                .append("firstName", firstName)
//                .append("middleName", middleName)
//                .append("lastName", lastName)
//                .append("suffix", suffix)
//                .toString();

        return (StringUtils.isBlank(title) ? "" : title + " ")
                + (StringUtils.isBlank(firstName) ? "" : firstName + " ")
                + (StringUtils.isBlank(middleName) ? "" : middleName + " ")
                + (StringUtils.isBlank(lastName) ? "" : lastName + " ")
                + (StringUtils.isBlank(suffix) ? "" : suffix + " ");
    }
}
