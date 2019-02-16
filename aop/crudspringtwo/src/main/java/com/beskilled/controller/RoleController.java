package com.beskilled.controller;

import com.beskilled.entity.Role;
import com.beskilled.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;

@Controller
public class RoleController {
    @Autowired
    private RoleRepository roleRepo;

    @GetMapping(value = "/view")
    public String view(Model model){
        model.addAttribute("listRole", this.roleRepo.findAll());
        return "role-view";
    }

    @GetMapping(value = "/addrole")
    public String addRoleView(Role role){
        return "role-add";
    }

    @PostMapping(value = "/addrole")
    public String addRole(@Valid Role role, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "role-add";
        }
        this.roleRepo.save(role);
        model.addAttribute("role", new Role());
        model.addAttribute("succAdd", "Successfully add role");
        return "role-add";
    }
}
