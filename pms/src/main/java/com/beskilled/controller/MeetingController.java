package com.beskilled.controller;

import com.beskilled.entity.Department;
import com.beskilled.entity.Meeting;
import com.beskilled.entity.User;
import com.beskilled.repo.DepartmentRepository;
import com.beskilled.repo.MeetingRepository;
import com.beskilled.repo.OrganizationRepository;
import com.beskilled.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/meet/")
public class MeetingController {
    @Autowired
    private MeetingRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private OrganizationRepository orgRepo;


    @GetMapping(value = "add")
    public String deptAdd(Model model) {
        model.addAttribute("meeting", new Meeting());

        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "meetings/add";
    }

    @PostMapping(value = "add")
    public String deptAdd(@Valid Meeting meeting, BindingResult result, Model model) {


        if (result.hasErrors()) {
            return "meetings/add";

        } else {

            this.repo.save(meeting);
            model.addAttribute("meeting", new Meeting());
            model.addAttribute("successMsg", "Successfully Saved!");
            try {
                String to = "";
                String message = "";
                for (User user : meeting.getUsers()) {
                    to = user.getMobile(); //Recipient Phone Number multiple number must be separated by comma
                    message = "Hi, " + user.getFirstName() + ", Next "+meeting.getStartDate() +" "+meeting.getSubject() + "::: Called By " + meeting.getOrganization().getOrgChiefName() + "," + meeting.getOrganization().getOrgName();
                    String token = "4c7fbb7eb69dcbe230dc0d9d899d9b91"; //generate token from the control panel
                    String uri = "http://api.greenweb.com.bd/api.php?token=" + token + "&to=" + to + "&message=" + message;
                    RestTemplate restTemplate = new RestTemplate();
                    String results = restTemplate.getForObject(uri, String.class);
                }

                System.out.println("Success");

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "meetings/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("meeting", repo.getOne(id));
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "meetings/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Meeting meeting, BindingResult result, Model model, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            model.addAttribute("userList", this.userRepo.findAll());
            model.addAttribute("orgList", this.orgRepo.findAll());
            return "meetings/edit";
        } else {
            meeting.setId(id);
            this.repo.save(meeting);
        }
        model.addAttribute("userList", this.userRepo.findAll());
        model.addAttribute("orgList", this.orgRepo.findAll());
        return "redirect:/meet/list";
    }

    @GetMapping(value = "del/{id}")
    public String Delet(@PathVariable("id") Long id) {
        if (id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/meet/list";
    }

    @GetMapping(value = "list")
    public String viewList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "meetings/list";
    }
}
