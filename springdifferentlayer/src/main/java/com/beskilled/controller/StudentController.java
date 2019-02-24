package com.beskilled.controller;

import com.beskilled.entity.Student;
import com.beskilled.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/test/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable("id") Long id){
        return studentService.findById(id);
    }
    @GetMapping(value = "/list")
    @ResponseBody
    public List<Student> getStudentList(){
        return studentService.getListAll();
    }
}
