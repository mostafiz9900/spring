package com.beskilled.controller;

import com.beskilled.entity.Role;
import com.beskilled.repository.RoleRepository;
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
    private RoleRepository roleRepo;

    @GetMapping("/viewrole")
    public String roleView(Model model) {
        model.addAttribute("list", this.roleRepo.findAll());
        return "role/view";
    }

    @GetMapping("/addrole")
    public String roleAdd(Role role) {
        return "role/add";
    }

    @PostMapping("/addrole")
    public String roleAddView(@Valid Role role, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "role/add";
        }
        this.roleRepo.save(role);
        model.addAttribute("role", new Role());
        model.addAttribute("roleMsg", "Successfully Data Insert ");
        return "role/add";

    }

    @GetMapping("/editrole/{id}")
    public String roleEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("role" , this.roleRepo.getOne(id));
        return "role/edit";
    }

    @PostMapping("/editrole/{id}")
    public String roleEdit(@Valid Role role, @PathVariable("id") Long id, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "role/edit";
        }
        this.roleRepo.save(role);
        model.addAttribute("role", new Role());
        return "redirect:/view";

    }

    @GetMapping("/delrole/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.roleRepo.deleteById(id);
        }
        return "redirect:/view/";
    }

}
