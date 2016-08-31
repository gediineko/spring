package com.exist.web.controllers;

import com.exist.model.dto.ContactDto;
import com.exist.model.dto.UserProfileDto;
import com.exist.model.entities.Role;
import com.exist.model.exception.EntityDoesNotExistException;
import com.exist.services.RoleService;
import com.exist.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private RoleService roleService;

    @RequestMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String get(Model model){
        model.addAttribute("userList", userProfileService.getAll());
        return "user/list";
    }

    @RequestMapping(path = "/role")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String role(Model model){
        model.addAttribute("roleList", roleService.getAll());
        return "role/list";
    }

    @RequestMapping(path = "/profile/{userId}")
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userId)")
    public String profile(@PathVariable Long userId, Model model) throws EntityDoesNotExistException {
        UserProfileDto userProfile = userProfileService.get(userId);
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("readonly", true);
        model.addAttribute("hidden", false);
        return "user/profile";
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String create(@ModelAttribute UserProfileDto userProfile){
        userProfileService.create(userProfile);
        return "redirect:/user";
    }

    //in progress
    @RequestMapping(path = "/update/{userId}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userProfile.id)")
    public String update(@ModelAttribute UserProfileDto userProfile, @PathVariable Long userId, Model model)
            throws EntityDoesNotExistException {
        userProfile = userProfileService.get(userId);
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("readonly", false);
        model.addAttribute("hidden", false);
        userProfileService.update(userProfile);
        return "user/profile";
    }

    @RequestMapping(path="/delete/{userId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String delete(@PathVariable Long userId){
        userProfileService.delete(userId);
        return "redirect:/user";
    }

    @RequestMapping(path="/profile/contact/delete", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userProfileId)")
    public String deleteContact(@RequestParam Long userProfileId, @RequestParam Long contactId){
        userProfileService.removeContact(userProfileId, contactId);
        return "redirect:/user/profile/" + userProfileId;
    }

    @RequestMapping(path = "/profile/contact", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userProfileId)")
    public String addContact(@RequestParam Long userProfileId, @ModelAttribute ContactDto contactDto){
        userProfileService.addContact(userProfileId, contactDto);
        return "redirect:/user/profile/" + userProfileId;
    }

    @RequestMapping(path = "/profile/contact", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userProfileId)")
    public String updateContact(@RequestParam Long userProfileId, @ModelAttribute ContactDto contactDto){
        userProfileService.updateContact(contactDto);
        return "redirect:/user/profile/" + userProfileId;
    }


}
