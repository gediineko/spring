package com.exist.web.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping
    @PreAuthorize("hasAuthority('USER')")
    public String get(){
        return "user/profile";
    }

}
