package com.exist.web.controllers;

import com.exist.model.dto.RoleDto;
import com.exist.model.exception.EntityAlreadyExistsException;
import com.exist.model.ref.RoleType;
import com.exist.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String get(Model model){
        model.addAttribute("roleTypeList", RoleType.values());
        model.addAttribute("roleList", roleService.getAll());
        return "role/list";
    }

    @RequestMapping(path = "/addUpdateRole", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String add(@ModelAttribute RoleDto roleDto, Model model) throws EntityAlreadyExistsException{
        model.addAttribute("roleTypeList", RoleType.values());
        roleService.create(roleDto);
        return "redirect:/role";
    }

    @RequestMapping(path = "/delete/{roleId}", method = RequestMethod.POST)
    public String delete(@PathVariable Long roleId) throws EntityAlreadyExistsException{
        roleService.delete(roleId);
        return "redirect:/role";
    }
}
