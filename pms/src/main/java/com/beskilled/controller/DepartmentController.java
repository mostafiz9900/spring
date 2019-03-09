package com.beskilled.controller;

import com.beskilled.entity.Department;
import com.beskilled.repo.DepartmentRepository;
import com.beskilled.repo.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/dept/")
public class DepartmentController {
    @Autowired
    private DepartmentRepository repo;

    @Autowired
    private OrganizationRepository orgRepo;



    @GetMapping(value = "add")
    public String deptAdd(Model model){
        model.addAttribute("dept" , new Department());
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "departments/add";
    }

    @PostMapping(value = "add")
    public String deptAdd(@Valid Department department, BindingResult result, Model model){
        if(result.hasErrors()){
            return "departments/add";

        }else{
            department.setShortName(department.getShortName().toUpperCase());
            this.repo.save(department);
            model.addAttribute("dept", new Department());
            model.addAttribute("successMsg","Successfully Saved!");
        }
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "departments/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("dept",repo.getOne(id));
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "departments/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Department department, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("orgList", this.orgRepo.findAll());
            return "departments/edit";
        }
        else{
            department.setId(id);
            this.repo.save(department);
        }
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "redirect:/dept/list";
    }

    @GetMapping(value = "del/{id}")
    public String Delet(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/dept/list";
    }

    @GetMapping(value = "list")
    public String viewList(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "departments/list";
    }
}
