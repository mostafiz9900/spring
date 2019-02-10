package com.beskilled.controller;

import com.beskilled.entity.User;
import com.beskilled.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepo repo;
    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "index";

    }
    @GetMapping(value = "/add")
    public String veiwAdd(User user){
        return "add-page";
    }
    @PostMapping(value = "/add")
    public String save(@Valid User user, Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "add-page";
        }
        this.repo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("Msg","Successfulled insert data");
        return "add-page";
    }
}
