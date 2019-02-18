package com.beskilled.controller;

import com.beskilled.entitly.Role;
import com.beskilled.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/save-role")
    public String saveRole() {
        Role role = new Role();
        role.setRoleName("SUPERADMIN");
        roleRepo.save(role);

        Role role2 = new Role();
        role2.setRoleName("ADMIN");
        roleRepo.save(role2);
        Role role3 = new Role();
        role3.setRoleName("USER");
        roleRepo.save(role3);
        System.out.println("Role success insert");
        return "success";
    }
}
