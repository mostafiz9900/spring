package com.beskilled.controller;

import com.beskilled.entity.Student;
import com.beskilled.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class studentController {
    @Autowired
    private StudentRepo repo;

    /*@GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", new Student());
        mv.setViewName("index");
        return mv;
    }

    @PostMapping(value = "/")
    public ModelAndView save(@Valid Student student) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", "hone | beSkilled");
        if (student.getName() != null) {
            this.repo.save(student);
            mv.addObject("successMsg", "Successfully sava data");
            mv.addObject("student", new Student());
        }

        mv.setViewName("index");//folder location
        return mv;
    }*/
    @GetMapping(value = "/add")
    public String showIndex(Student student) {
        return "add";

    }

    @PostMapping(value = "/add")
    public String save(@Valid Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        this.repo.save(student);
        model.addAttribute("student", new Student());
        model.addAttribute("successMsg", "Successfully data insert");
        return "add";
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "index";

    }

   /* @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        if (id != null) {
            this.repo.deleteById(id);
           model.addAttribute("delMsg", "Delet a Usre Successfully");
        }

        return "redirect:/";

    }*/
    @GetMapping("/edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
       model.addAttribute("student", this.repo.getOne(id));
        return "edit";

    }
    @PostMapping("/edit/{id}")
    public String edit(@Valid Student student, @PathVariable("id") Long id, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
           return "edit";
//            model.addAttribute("delMsg", "Delet a Usre Successfully");
        }

        this.repo.save(student);
//        model.addAttribute("student", new Student());

        return "redirect:/";

    }

    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id){
        if(id != null){
            this.repo.deleteById(id);
        }
        return "redirect:/";
    }
}
