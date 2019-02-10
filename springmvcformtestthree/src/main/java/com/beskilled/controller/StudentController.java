package com.beskilled.controller;

import com.beskilled.entity.User;
import com.beskilled.ropository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo repo;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "index";
    }

    @GetMapping(value = "/add")
    public String showAdd(User user) {
        return "add-page";
    }

    @PostMapping(value = "/add")
    public String save(@Valid User user, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-page";
        }
        user.setRegDate(new Date());
        this.repo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("Msg", "Successfully data insert");
        return "add-page";
    }

    @GetMapping(value = "/edit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", this.repo.getOne(id));
        return "editPage";

    }

    @PostMapping(value = "/edit/{id}")
    public String edit(@Valid User user, @PathVariable("id") Integer id, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editPage";
        }
        this.repo.save(user);
        return "redirect:/";

    }

    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if (id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/";
    }

}
