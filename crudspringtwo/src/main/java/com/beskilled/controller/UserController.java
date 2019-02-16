package com.beskilled.controller;

import com.beskilled.entity.User;
import com.beskilled.repository.RoleRepository;
import com.beskilled.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("list", this.userRepo.findAll());

        return "index-page";
    }

    @GetMapping(value = "/add")
    public String addView(User user, Model model) {
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "add-page";

    }


    @PostMapping(value = "/add")
    public String add(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-page";
        }
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("success", "Insert data successfully");
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "add-page";

    }

    @GetMapping(value = "/edit/{id}")
    public String edtiView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userRepo.getOne(id));
        model.addAttribute("rolelist", this.roleRepo.findAll());

        return "edit-page";

    }

    @PostMapping(value = "/edit/{id}")
    public String edit(@Valid User user, @PathVariable("id") Long id, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/edit-page";
        }
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("successEdit", "Update data successfully");
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "edit-page";

    }

    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.userRepo.deleteById(id);
        }
        return "redirect:/";
    }

}

