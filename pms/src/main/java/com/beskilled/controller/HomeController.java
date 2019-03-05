package com.beskilled.controller;

import com.beskilled.entity.User;
import com.beskilled.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   /* @Autowired
    private UserRepository userRepository;*/

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }
    @GetMapping(value = "/la")
    public String layout(){
        return "layout";
    }
    /*@GetMapping(value = "/admin")
    public String adminView(){
        return "admin/addmin";
    }
    @GetMapping(value = "/user")
    public String userView(){
        return "user/user";
    }
    @GetMapping(value = "/sd")
    public String superView(){
        return "superadmin/sadmin";
    }

    @GetMapping(value = "/se")
    public String securView(Model model){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username",auth.getName());

        User user=userRepository.findByUsername(auth.getName());
        model.addAttribute("name", user.getFirstName());
        model.addAttribute("email", user.getEmail());
        return "secure/secure";
    }*/

}
