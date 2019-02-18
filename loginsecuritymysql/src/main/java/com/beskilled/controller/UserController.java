package com.beskilled.controller;

import com.beskilled.entitly.Role;
import com.beskilled.entitly.User;
import com.beskilled.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/save-user")
    public String saveUser(){
        User user=new User();
        Set<Role> roles=new HashSet<>();
        roles.add(new Role(1L));
        roles.add(new Role(2L));

        user.setName("mostafiz");
        user.setEmail("mosta@gmail.com");
        user.setUsername("mosta");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setStatus(true);
        user.setRole(roles);
        userRepo.save(user);






        User user2=new User();
        Set<Role> roles2=new HashSet<>();
        roles2.add(new Role(2L));
        roles2.add(new Role(3L));

        user2.setName("sofiq");
        user2.setEmail("sofiqsofiq@gmail.com");
        user2.setUsername("sofiq");
        user2.setPassword(passwordEncoder.encode("1234"));
        user2.setStatus(true);
        user2.setRole(roles2);
        userRepo.save(user2);

return "success";
    }
}
