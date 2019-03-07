package com.beskilled.controller;


import com.beskilled.entity.Role;
import com.beskilled.entity.User;
import com.beskilled.repo.RoleRepository;
import com.beskilled.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@Controller
public class UserControllerStaticData {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping(value = "/user-save")
    public String saveUser() {

        Set<Role> roles=new HashSet<>();
        roles.add(new Role("SUPERADMIN"));
        roles.add(new Role("ADMIN"));
        roles.add(new Role("CADMIN"));
        roles.add(new Role("PM"));
        roles.add(new Role("TEAMLEAD"));
        roles.add(new Role("DEVELOPER"));
        roles.add(new Role("USER"));
        roles.forEach((role -> {
            roleRepo.save(role);
        }));

        roles.add(new Role(1L));
        roles.add(new Role(2L));

        User user = new User("Mostafizur","Rahman","mostafiz","admin@gmail.com",new Date(),true,UUID.randomUUID().toString(),roles);
        user.setPassword(passwordEncoder.encode("mostafiz"));
        repo.save(user);
        return "success";
    }

    @GetMapping(value = "/register")
    public ModelAndView displayRegister(User user){
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("signup");
        return mv;
    }
}