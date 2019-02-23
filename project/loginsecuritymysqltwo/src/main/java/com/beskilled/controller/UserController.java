package com.beskilled.controller;

import com.beskilled.entity.Role;
import com.beskilled.entity.User;
import com.beskilled.repo.RoleRepository;
import com.beskilled.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    /*
    @GetMapping(value = "/save-user")
        public String savrUser() {
            Set<Role> roles = new HashSet<>();
            roles.add(new Role(1L));
            roles.add(new Role(2L));
            roles.add(new Role(3L));
            User user = new User("Mostafizur", "mostafiz@gmail.com", "mostafiz", passwordEncoder.encode("1234"), true, roles);
            userRepo.save(user);

            Set<Role> roles2 = new HashSet<>();
            roles2.add(new Role(2L));
            roles2.add(new Role(3L));
            User user2 = new User("Sofiqul", "sofiqul@gmail.com", "sofiqul", passwordEncoder.encode("1234"), true, roles2);
            userRepo.save(user2);
            return "success";
        }
    */
    @GetMapping(value = "userview")
    public String userView(Model model) {
        model.addAttribute("userlist", this.userRepo.findAll());

        return "user/view";

    }

    @GetMapping(value = "save-user")
    public String userAddView(User user, Model model) {
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "user/user-add";

    }

    @PostMapping(value = "save-user")
    public String AddView(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/user-add";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("userMsgSucc", "user insert success data");
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "user/user-add";

    }

    @GetMapping(value = "edit-user/{id}")
    public String userEditView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userRepo.getOne(id));
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "user/user-edit";

    }

    @PostMapping(value = "edit-user/{id}")
    public String userAddVEdit(@Valid User user, @PathVariable("id") Long id, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("rolelist", this.roleRepo.findAll());
            return "user/user-edit";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "redirect:/user/userview";
    }

    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.userRepo.deleteById(id);
        }
        return "redirect:/user/userview";
    }
}
