package com.beskilled.controller;

import com.beskilled.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;

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
        return "admin/adm";
    }
    @GetMapping(value = "/us")
    public String userView(){
        return "user/user-page";
    }
    @GetMapping(value = "/sd")
    public String superView(){
        return "superadmin/supAd";
    }

}
