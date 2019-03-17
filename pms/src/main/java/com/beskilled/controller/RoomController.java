package com.beskilled.controller;

import com.beskilled.entity.Bhaban;
import com.beskilled.entity.Room;
import com.beskilled.repo.BhabanRepository;
import com.beskilled.repo.FloorRepository;
import com.beskilled.repo.OrganizationRepository;
import com.beskilled.repo.RoomRepository;
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
@RequestMapping(value = "/room/")
public class RoomController {
    @Autowired
    private RoomRepository repo;

    @Autowired
    private FloorRepository floorRepo;



    @GetMapping(value = "add")
    public String bhabanAdd(Model model){
        model.addAttribute("room",new Room());
        model.addAttribute("floorList", this.floorRepo.findAll());
        return "rooms/add";
    }

    @PostMapping(value = "add")
    public String bhabanAdd(@Valid Room room, BindingResult result, Model model){
        if(result.hasErrors()){
            return "rooms/add";

        }else{
            this.repo.save(room);
            model.addAttribute("room", new Room());
            model.addAttribute("successMsg","Successfully Saved!");
        }
        model.addAttribute("floorList", this.floorRepo.findAll());
        return "rooms/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("room",repo.getOne(id));
        model.addAttribute("floorList", this.floorRepo.findAll());
        return "rooms/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Room room, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("floorList", this.floorRepo.findAll());
            return "rooms/edit";
        }
        else{
            room.setId(id);
            this.repo.save(room);
        }
        model.addAttribute("floorList", this.floorRepo.findAll());
        return "redirect:/room/list";
    }

    @GetMapping(value = "del/{id}")
    public String delet(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/room/list";
    }

    @GetMapping(value = "list")
    public String Lists(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "rooms/list";
    }
}
