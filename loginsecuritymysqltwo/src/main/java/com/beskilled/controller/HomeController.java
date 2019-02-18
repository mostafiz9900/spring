package com.beskilled.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/in")
    public String index(){
        return "index";
    }
    @GetMapping(value = "/la")
    public String layout(){
        return "layout";
    }
    @GetMapping(value = "/adm")
    public String adminView(){
        return "admin/admin";
    }
    @GetMapping(value = "/us")
    public String userView(){
        return "user/user";
    }
    @GetMapping(value = "/sd")
    public String superView(){
        return "superadmin/sadmin";
    }

    @GetMapping(value = "/se")
    public String securView(){
        return "secure/secure";
    }
}
