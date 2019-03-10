package com.beskilled.controller;

import com.beskilled.entity.Department;
import com.beskilled.entity.Minor;
import com.beskilled.repo.DepartmentRepository;
import com.beskilled.repo.MeetingRepository;
import com.beskilled.repo.MinorRepository;
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
@RequestMapping(value = "/minor/")
public class MinorController {
    @Autowired
    private MinorRepository repo;

    @Autowired
    private MeetingRepository meetingRepo;



    @GetMapping(value = "add")
    public String deptAdd(Model model){
        model.addAttribute("minor" , new Minor());
        model.addAttribute("meetingList", this.meetingRepo.findAll());
        return "minors/add";
    }

    @PostMapping(value = "add")
    public String deptAdd(@Valid Minor minor, BindingResult result, Model model){
        if(result.hasErrors()){
            return "minors/add";

        }else{
            this.repo.save(minor);
            model.addAttribute("minor", new Minor());
            model.addAttribute("successMsg","Successfully Saved!");
        }
        model.addAttribute("meetingList", this.meetingRepo.findAll());
        return "minors/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("minor",repo.getOne(id));
        model.addAttribute("meetingList", this.meetingRepo.findAll());
        return "minors/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Minor minor, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("meetingList", this.meetingRepo.findAll());
            return "minors/edit";
        }
        else{
            minor.setId(id);
            this.repo.save(minor);
        }
        model.addAttribute("meetingList", this.meetingRepo.findAll());
        return "redirect:/minor/list";
    }

    @GetMapping(value = "del/{id}")
    public String Delet(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/minor/list";
    }

    @GetMapping(value = "list")
    public String viewList(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "minors/list";
    }
}
