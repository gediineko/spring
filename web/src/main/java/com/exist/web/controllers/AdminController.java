package com.exist.web.controllers;

import com.exist.model.dto.UserAccountDto;
import com.exist.model.exception.EntityAlreadyExistsException;
import com.exist.model.exception.EntityDoesNotExistException;
import com.exist.model.exception.InvalidFileTypeException;
import com.exist.model.ref.RoleType;
import com.exist.services.RoleService;
import com.exist.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private RoleService roleService;

    @RequestMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String get(){
        return "admin/dashboard";
    }

    @RequestMapping(path = "/profile/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String profile(@PathVariable Long userId, Model model) throws EntityDoesNotExistException {
        UserAccountDto userAccountDto = userAccountService.get(userId);
        model.addAttribute("userAccount", userAccountDto);
        model.addAttribute("readonly", true);
        model.addAttribute("hidden", true);
        return "admin/profile";
    }

    @RequestMapping(path = "/update/{userId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String update(@PathVariable Long userId, Model model)
            throws EntityDoesNotExistException {
        UserAccountDto userAccountDto = userAccountService.get(userId);
        model.addAttribute("userAccount", userAccountDto);
        model.addAttribute("readonly", false);
        model.addAttribute("hidden", false);
        model.addAttribute("createMode", false);
        return "admin/profile";
    }


    @RequestMapping("/list")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAdmin(Model model){
        List<UserAccountDto> adminList = userAccountService.getAll();
        model.addAttribute("adminList", adminList);
        return "admin/list";
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String createPage(Model model) {
        model.addAttribute("userAccount", new UserAccountDto());
        model.addAttribute("readonly", false);
        model.addAttribute("hidden", true);
        model.addAttribute("createMode", true);
        model.addAttribute("adminRoleList", roleService.getAllByType(RoleType.ADMIN));
        return "admin/profile";
    }


    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String create(@ModelAttribute UserAccountDto userAccountDto) throws EntityAlreadyExistsException {
        System.out.println(userAccountDto.getInitialRole());
        userAccountService.create(userAccountDto);
        return "redirect:/admin/list";
    }


    @RequestMapping(method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String update(@ModelAttribute UserAccountDto userAccountDto){
        userAccountService.update(userAccountDto);
        return "redirect:/admin/list";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(@RequestParam Long userAccountId) throws EntityDoesNotExistException {
        userAccountService.delete(userAccountId);
        return "redirect:/admin/list";
    }

    @RequestMapping(path = "/user/upload", method = RequestMethod.POST)
    public String uploadAccounts(@RequestParam("file") MultipartFile file) throws InvalidFileTypeException, IOException {
        if(!file.getContentType().equals("text/csv")){
            throw new InvalidFileTypeException("Invalid File Type!", "error.invalid.fileType", new Object[]{"CSV"});
        }
        userAccountService.uploadUsers(file);

        return "redirect:/user";
    }
}
