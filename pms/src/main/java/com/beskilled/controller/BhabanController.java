package com.beskilled.controller;

import com.beskilled.entity.Bhaban;
import com.beskilled.repo.BhabanRepository;
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
@RequestMapping(value = "/bhaban/")
public class BhabanController {
    @Autowired
    private BhabanRepository repo;
    @Autowired
    private OrganizationRepository orgRepo;



    @GetMapping(value = "add")
    public String bhabanAdd(Model model){
        model.addAttribute("bhaban",new Bhaban());
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "bhabans/add";
    }

    @PostMapping(value = "add")
    public String bhabanAdd(@Valid Bhaban bhaban, BindingResult result, Model model){
        if(result.hasErrors()){
            return "bhabans/add";

        }else{
            this.repo.save(bhaban);
            model.addAttribute("bhaban", new Bhaban());
            model.addAttribute("successMsg","Successfully Saved!");
        }
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "bhabans/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("bhaban",repo.getOne(id));
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "bhabans/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Bhaban bhaban, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("orgList", this.orgRepo.findAll());
            return "bhabans/edit";
        }
        else{
            bhaban.setId(id);
            bhaban.setBhabanName(bhaban.getBhabanName().toUpperCase());
            this.repo.save(bhaban);
        }
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "redirect:/bhaban/list";
    }

    @GetMapping(value = "del/{id}")
    public String bhabanDel(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/bhaban/list";
    }

    @GetMapping(value = "list")
    public String bhabanList(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "bhabans/list";
    }
}
