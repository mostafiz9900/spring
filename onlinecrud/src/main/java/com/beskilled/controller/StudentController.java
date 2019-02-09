package com.beskilled.controller;

import com.beskilled.dao.StudentDAO;
import com.beskilled.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;
    @GetMapping("/add")
    public String add(ModelMap modelMap){
        Student student=new Student();
        modelMap.addAttribute("student", student);
        return "add";

    }
}
