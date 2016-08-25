package com.exist.web.controllers;

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
}
