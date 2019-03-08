package com.beskilled.controller;

import com.beskilled.entity.Designation;
import com.beskilled.entity.Floor;
import com.beskilled.repo.BhabanRepository;
import com.beskilled.repo.DesignationRepository;
import com.beskilled.repo.FloorRepository;
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
@RequestMapping(value = "/floor/")
public class FloorController {
    @Autowired
    private FloorRepository repo;
@Autowired
    private BhabanRepository  bhabanRepo;



    @GetMapping(value = "add")
    public String degtAdd(Model model){
        model.addAttribute("floor",new Floor());
        model.addAttribute("bhabanList", this.bhabanRepo.findAll());
        return "floors/add";
    }

    @PostMapping(value = "add")
    public String deptAdd(@Valid Floor floor, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("list",this.repo.findAll());
            return "floors/add";

        }else{
            this.repo.save(floor);
            model.addAttribute("floor", new Floor());
            model.addAttribute("successMsg","Successfully Saved!");
        }
        model.addAttribute("bhabanList", this.bhabanRepo.findAll());

        return "floors/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("floor",repo.getOne(id));

        model.addAttribute("bhabanList", this.bhabanRepo.findAll());

        return "floors/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Floor floor, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("bhabanList", this.bhabanRepo.findAll());
            return "floors/edit";
        }
        else{
            floor.setId(id);

            this.repo.save(floor);
        }

        model.addAttribute("bhabanList", this.bhabanRepo.findAll());

        return "redirect:/floor/list";
    }

    @GetMapping(value = "del/{id}")
    public String Delet(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/floor/list";
    }

    @GetMapping(value = "list")
    public String viewList(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "floors/list";
    }
}
