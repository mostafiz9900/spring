package com.beskilled.controller;

import com.beskilled.MeetingMinorsDto;
import com.beskilled.entity.*;
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
import java.util.Date;

@Controller
@RequestMapping(value = "/minor/")
public class MinorController {
    @Autowired
    private MinorRepository repo;

    @Autowired
    private MeetingRepository meetingRepo;



    @GetMapping(value = "add/{id}")
    public String deptAdd(Model model, @PathVariable("id") Long id){
        Meeting meeting = meetingRepo.getOne(id);
        MeetingMinorsDto dto=new MeetingMinorsDto(meeting.getId(), meeting.getStartDate(), meeting.getSubject(), meeting.getBody(), "", meeting.getUsers(), meeting.getOrganization(), "");

        model.addAttribute("dto", dto);
        return "minors/add";
    }

    @PostMapping(value = "add/{id}")
    public String deptAdd(@Valid MeetingMinorsDto dto, BindingResult result, Model model){
        if(result.hasErrors()){
            return "minors/add";

        }else{
           Minor minor=new Minor();
           minor.setMeetingTitle(dto.getMeetingsubject());
           minor.setAgendaAction(dto.getMeetingAgenda());
           minor.setRemark(dto.getRemarks());
            /////////dto theke value ene minor obj set korbe then save
            this.repo.save(minor);
            model.addAttribute("minor", new Minor());
            model.addAttribute("successMsg","Successfully Saved!");
        }
       /* model.addAttribute("meetingList", this.meetingRepo.findAll());*/
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
