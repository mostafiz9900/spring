package com.beskilled.controller;

import com.beskilled.entity.Role;
import com.beskilled.entity.User;
import com.beskilled.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;
@GetMapping(value = "/save-user")
    public String savrUser() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L));
        roles.add(new Role(2L));
        roles.add(new Role(3L));
        User user = new User("Mostafizur", "mostafiz@gmail.com", "mostafiz", passwordEncoder.encode("1234"), true, roles);
        userRepo.save(user);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(new Role(2L));
        roles2.add(new Role(3L));
        User user2 = new User("Sofiqul", "sofiqul@gmail.com", "sofiqul", passwordEncoder.encode("1234"), true, roles2);
        userRepo.save(user2);
        return "success";
    }
}
