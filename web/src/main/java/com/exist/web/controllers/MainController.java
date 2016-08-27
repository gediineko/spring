package com.exist.web.controllers;

import com.exist.model.entities.UserAccount;
import com.exist.services.util.RoleUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping
    public String get(Model model){
        model.addAttribute("Test", "Spring");
        return "index";
    }

    @RequestMapping("/login/success")
    @PreAuthorize("isAuthenticated()")
    public String successHandler(@AuthenticationPrincipal UserAccount userAccount){
        if (RoleUtil.isAdmin(userAccount.getRoles())){
            return "redirect:/admin";
        }
        return "redirect:/user";
    }
}
