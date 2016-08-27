package com.exist.web.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String get(){
        return "admin/dashboard";
    }
}
