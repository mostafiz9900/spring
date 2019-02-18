package com.beskilled.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

    @GetMapping(value = "/i")
    public String index(){
        return "index";
    }
    @GetMapping(value = "/layout")
    public String layout(){
        return "layout";
    }

    @GetMapping(value = "/user")
    public String user(){
        return "user/user";
    }
    @GetMapping(value = "/sa")
    public String superAdmin(){
        return "sadmin/sad";
    }
    @GetMapping(value = "/se")
    public String security(){
        return "secure/sec";
    }

    @GetMapping(value = "/adm")
    public String adminView(){
        return "admin/admin";
    }
}
