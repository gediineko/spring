package com.exist.web.controllers;

import com.exist.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ggolong on 9/1/16.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String role(Model model){
        model.addAttribute("roleList", roleService.getAll());
        return "role/list";
    }
}
