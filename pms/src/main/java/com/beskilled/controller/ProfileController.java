package com.beskilled.controller;

import com.beskilled.entity.User;
import com.beskilled.repo.RoleRepository;
import com.beskilled.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;
    @GetMapping(value = "/profile")
    public String profileView(Model model){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        /*model.addAttribute("username", auth.getName());*/
       User user=this.userRepo.findByUserName(auth.getName());
       /* model.addAttribute("name", user.getFirstName());*/
        model.addAttribute("user", user);


        /*model.addAttribute("list", this.roleRepo.findAll());*/
        return "profile";
    }
}
