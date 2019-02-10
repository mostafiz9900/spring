package com.beskilled.controller;

import com.beskilled.dao.StudentDAO;
import com.beskilled.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.ObjectOutput;
import java.util.List;

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
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveReg(@Valid Student student, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            System.out.println("has error");
            return "enroll";
        }
        studentDAO.save(student);
        return "redirect:/viewstudents";

    }
   /* @RequestMapping(value = "/viewstudents")
    public ModelAndView getAll(){
        List<Student> list=studentDAO.findAll();
        return "redirect:/viewstudents";

    }*/
}
