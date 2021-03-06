package com.exist.config;

import com.exist.model.dto.*;
import com.exist.model.entities.*;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by ggolong on 8/26/16.
 */
@Configuration
public class DozerConfig {
    @Bean
    public DozerBeanMapper mapper(){
        return new DozerBeanMapper();
    }

    @PostConstruct
    public void initMapper(){
        mapper().addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(AddressDto.class, Address.class);

                mapping(
                        ContactDto.class,
                        Contact.class,
                        TypeMappingOptions.oneWay()
                ).exclude("id");

                mapping(Contact.class, ContactDto.class, TypeMappingOptions.oneWay());

                mapping(NameDto.class, Name.class);

                mapping(
                        RoleDto.class,
                        Role.class,
                        TypeMappingOptions.oneWay()
                ).exclude("id");

                mapping(Role.class, RoleDto.class, TypeMappingOptions.oneWay());

                mapping(
                        UserAccountDto.class,
                        UserAccount.class,
                        TypeMappingOptions.oneWay()
                ).exclude("id");

                mapping(UserAccount.class, UserAccountDto.class, TypeMappingOptions.oneWay());

                mapping(
                        UserProfileDto.class,
                        UserProfile.class,
                        TypeMappingOptions.oneWay(),
                        TypeMappingOptions.mapNull(false)
                ).exclude("id").exclude("roles").exclude("contactInfo");

                mapping(UserProfile.class, UserProfileDto.class, TypeMappingOptions.oneWay());

                mapping(CSVRowDto.class, UserProfileDto.class, TypeMappingOptions.dateFormat("yyyy-MM-dd"))
                        .fields("title", "name.title")
                        .fields("firstName", "name.firstName")
                        .fields("middleName", "name.middleName")
                        .fields("lastName", "name.lastName")
                        .fields("suffix", "name.suffix")
                        .fields("streetNumber", "address.streetNumber")
                        .fields("barangay", "address.barangay")
                        .fields("city", "address.city")
                        .fields("zipCode", "address.zipCode");
//                        .exclude("id")
//                        .exclude("username");
            }
        });
    }
}
