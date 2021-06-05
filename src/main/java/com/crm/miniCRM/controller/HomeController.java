package com.crm.miniCRM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value="")
public class HomeController {

    @GetMapping
    public String showHome(){
        return "index";
    }
}
