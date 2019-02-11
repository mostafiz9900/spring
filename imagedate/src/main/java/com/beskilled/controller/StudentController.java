package com.beskilled.controller;

import com.beskilled.entity.Student;
import com.beskilled.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo repo;
    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "index";
    }
    @GetMapping(value = "/add")
    public String viewAdd(Student student){
        return "add";
    }
    @PostMapping(value = "/add")
    public String save(@Valid Student student, Model model, BindingResult result){
        if (result.hasErrors()){
            return "add";
        }
        this.repo.save(student);
        model.addAttribute("student", new Student());
        model.addAttribute("Msg", "Successfully insert data");
        return "add";
    }
}
