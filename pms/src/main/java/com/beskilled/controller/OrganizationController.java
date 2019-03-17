package com.beskilled.controller;

import com.beskilled.entity.Organization;
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
import java.util.Date;

@Controller
@RequestMapping(value = "/org/")
public class OrganizationController {
    @Autowired
    private OrganizationRepository repo;



    @GetMapping(value = "add")
    public String AddView(Model model){
        model.addAttribute("org",new Organization());
        return "organizations/add";
    }

    @PostMapping(value = "add")
    public String Adds(@Valid Organization organization, BindingResult result, Model model){
        if(result.hasErrors()){
            return "organizations/add";

        }else{
            organization.setRegistrationDate(new Date());
            this.repo.save(organization);
            model.addAttribute("org", new Organization());
            model.addAttribute("successMsg","Successfully Saved!");
        }
        return "organizations/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("org",repo.getOne(id));
        return "organizations/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edits(@Valid Organization organization, BindingResult result, Model model, @PathVariable("id") Long id){
        if(result.hasErrors()){
            return "organizations/edit";
        }
        else{
            organization.setId(id);
            this.repo.save(organization);
        }
        return "redirect:/org/list";
    }

    @GetMapping(value = "del/{id}")
    public String bhabanDel(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/org/list";
    }

    @GetMapping(value = "list")
    public String lists(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "organizations/list";
    }
}
