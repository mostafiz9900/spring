package com.beskilled.controller;

import com.beskilled.entity.Role;
import com.beskilled.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RoleController {
    @Autowired
    private RoleRepository roleRepo;
    @GetMapping(value = "/save-role")
    public String saveRole(){
     Role role=new Role();
     role.setRoleName("ADMIN");
     roleRepo.save(role);

        Role role2=new Role();
        role2.setRoleName("SUPERADMIN");
        roleRepo.save(role2);


        Role role3=new Role();
        role3.setRoleName("USER");
        roleRepo.save(role3);

        return "success";
    }
}
