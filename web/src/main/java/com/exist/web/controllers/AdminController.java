package com.exist.web.controllers;

import com.exist.model.dto.UserAccountDto;
import com.exist.model.exception.InvalidFileTypeException;
import com.exist.model.ref.RoleType;
import com.exist.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String get(){
        return "admin/dashboard";
    }

    @RequestMapping("/list")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAdmin(Model model){
        List<UserAccountDto> adminList = userAccountService.getAll();
        List<RoleType> roleTypeList = new ArrayList<>();
        roleTypeList.add(RoleType.ADMIN);
        roleTypeList.add(RoleType.USER);
        model.addAttribute("adminList", adminList);
        model.addAttribute("roleTypeList", roleTypeList);
        return "admin/list";
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
