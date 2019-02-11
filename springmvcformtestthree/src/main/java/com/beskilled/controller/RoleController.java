package com.beskilled.controller;

import com.beskilled.entity.UserRole;
import com.beskilled.ropository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/viewrole")
    public String roleView(Model model) {
        model.addAttribute("list", this.roleRepo.findAll());
        return "role/view-role";
    }

    @GetMapping(value = "/addrole")
    public String addRole(UserRole userRole) {
        return "role/add-role";

    }

    @PostMapping("/addrole")
    public String savaRole(@Valid UserRole userRole, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "role/add-role";
        }  else {
            if (userRole != null) {
                UserRole userRole1s = this.roleRepo.findByRoleName(userRole.getRoleName());
                if (userRole1s != null) {
                    model.addAttribute("exitMsg", "role name already exit");
                } else {
                    this.roleRepo.save(userRole);
                    model.addAttribute("userRole", new UserRole());
                    model.addAttribute("RoleMsg", "Successfully  Data Edit");

                }
            }
        }

        return "role/add-role";

    }

    @GetMapping(value = "/editrole/{id}")
    public String editShowRole(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("userRole", this.roleRepo.getOne(id));
        return "role/edit-role";

    }

    @PostMapping(value = "/editrole/{id}")
    public String editRole(@PathVariable("id") Integer id, @Valid UserRole userRole, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "role/edit-role";
        } else {

                    this.roleRepo.save(userRole);
                    model.addAttribute("userRole", new UserRole());
                    model.addAttribute("RoleMsgEdit", "Successfully  Data Edit");



        }
        return "role/edit-role";
    }

    @GetMapping(value = "/delrole/{id}")
    public String deleteRole(@PathVariable("id") Integer id) {
        if (id != null) {
            this.roleRepo.deleteById(id);
        }
        return "redirect:/";
    }
}
