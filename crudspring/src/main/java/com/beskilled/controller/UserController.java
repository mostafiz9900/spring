package com.beskilled.controller;

import com.beskilled.entity.User;
import com.beskilled.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("list", this.userRepo.findAll());
        return "index-page";
    }

    @GetMapping(value = "/add")
    public String addView(User user) {
        return "add-page";
    }

    @PostMapping(value = "/add")
    public String add(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-page";
        }
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("success", "Insert Data Successfully");
        return "add-page";
    }

    @GetMapping(value = "/edit/{id}")
    public String editView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userRepo.getOne(id));
        return "edit-page";
    }

    @PostMapping(value = "/add/{id}")
    public String edit(@Valid User user, @PathVariable("id") Long id, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-page";
        }
        this.userRepo.save(user);
        model.addAttribute("user", new User());

        return "redirect:/";
    }

    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.userRepo.deleteById(id);
        }
        return "redirect:/";

    }
}
