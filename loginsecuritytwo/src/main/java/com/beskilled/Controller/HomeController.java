package com.beskilled.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/login"})
    public String loginView(){
        return "login";

    }
    @GetMapping(value = "/public/r")
    public String regView(){
        return "public/reg";

    }

    @GetMapping(value = "/admin/h")
    public String homeView(){
        return  "admin/home";
    }
    @GetMapping(value = "/secutity/s")
    public String serviceView(){
        return  "secutity/service";

    }
    @GetMapping(value = "/user/u")
    public String userView(){
        return  "user/user";

    }
}
