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
                // Most Basic Mapping, two way mapping configuration to
                // AddressDto <-> Address
                mapping(AddressDto.class, Address.class);

                // One Way Mapping, pra hindi nya isama ung ID nung DTO dun sa entity
                // Pwede kase mag inject ng ibang ID si user kpag inedit ung
                //  Web source code. So this is only for ContactDto -> Contact
                mapping(
                        ContactDto.class,
                        Contact.class,
                        TypeMappingOptions.oneWay()
                ).exclude("id");

                // Need lang mag register pabalik, ung Entity ID to DTO ID, okay lang since
                // galing nman sa database un and usually this is just for viewing
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
                        TypeMappingOptions.oneWay()
                ).exclude("id");

                mapping(UserProfile.class, UserProfileDto.class, TypeMappingOptions.oneWay());

            }
        });
    }
}
