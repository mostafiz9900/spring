package com.beskilled.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value ={"/", "/login"})

    public String loginView(){
        return "login";
    }
    @GetMapping(value ="/public/r")
    public String regiView(){
        return "public/reg";
    }
    @GetMapping(value ="/public/a")
    public String aboutView(){
        return "public/about";
    }
    @GetMapping(value ="/user/u")
    public String userView(){
        return "user/user";
    }
    @GetMapping(value ="/admin/h")
    public String homeView(){
        return "admin/home";
    }


    @GetMapping(value ="/secuer/s")
    public String serviceView(){
        return "secuer/service";
    }
}
