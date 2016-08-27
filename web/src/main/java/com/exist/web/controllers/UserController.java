package com.exist.web.controllers;

import com.exist.model.dto.UserProfileDto;
import com.exist.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping
    @PreAuthorize("hasAuthority('USER')")
    public String get(){
        return "user/profile";
    }

    @RequestMapping(path = "/profile/{userId}")
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userId)")
    public String profile(@PathVariable Long userId, Model model){
        UserProfileDto userProfile = userProfileService.get(userId);
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("readonly", true);
        return "user/profile";
    }



    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String create(@ModelAttribute UserProfileDto userProfile){
        userProfileService.create(userProfile);
        return "redirect:/user";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userProfile.id)")
    public String update(@ModelAttribute UserProfileDto userProfile){
        userProfileService.update(userProfile);
        return "redirect:/user";
    }

}
