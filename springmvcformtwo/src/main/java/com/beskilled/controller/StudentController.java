package com.beskilled.controller;

import com.beskilled.entity.Student;
import com.beskilled.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo repo;

    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("stu", new Student());
        mv.setViewName("index");
        return mv;
    }

    @PostMapping(value = "/")
    public ModelAndView addStudent(@Valid Student student) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", "Home|beSkilled");
        if (student.getName() != null) {
            this.repo.save(student);
            mv.addObject("successMsg", "Successfully insert");
            mv.addObject("stu", new Student());
        }
        mv.setViewName("index");
        return mv;
    }
}
