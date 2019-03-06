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
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
<<<<<<< HEAD
    private PasswordEncoder passwordEncoder;
=======
    PasswordEncoder passwordEncoder;


    @GetMapping(value = "/user-save")
        public String savrUser() {
        Set<Role> roles=new HashSet<>();
        roles.add(new Role("SUPERADMIN"));
        roles.add(new Role("ADMIN"));
        roles.forEach((role -> {
            roleRepo.save(role);
        }));
            roles.add(new Role(1L));
            roles.add(new Role(2L));
        User user = new User("Mostafiz.","Rahman", "mostafiz", passwordEncoder.encode("mosta9900"), "mostafiz.java8@gmail.com", true,null, roles);
            userRepo.save(user);
>>>>>>> 97302f96fdbfb94be225f4d311fca9aa5382936f

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("user",new User());
        return "users/add";
    }
    @PostMapping(value = "add")
    public String add(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "users/add";
        }
        if(repo.existsByEmail(user.getEmail())){
            model.addAttribute("rejectMsg","Already Have This Entry");
        }else{
            String username = user.getEmail().split("\\@")[0];
            user.setUserName(username);
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setConfirmationToken(UUID.randomUUID().toString());
            this.repo.save(user);
            model.addAttribute("successMsg","Successfully Saved!");
        }

        return "users/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("user",repo.getOne(id));
        return "users/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid User user, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            return "users/edit";
        }
        Optional<User> u = this.repo.findByEmail(user.getEmail());
        if(u.get().getId() != id){
            model.addAttribute("rejectMsg","Already Have This Entry");
            return "users/edit";
        }else{
            user.setId(id);
            this.repo.save(user);
        }

        return "redirect:/user/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/user/list";
    }

    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "users/list";
    }

    /*@GetMapping(value = "/user-save")
    public String savrUser() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("SUPERADMIN"));
        roles.add(new Role("ADMIN"));
        roles.add(new Role("USER"));
        roles.forEach((role -> {
            roleRepo.save(role);
        }));
        roles.add(new Role(1L));
        roles.add(new Role(2L));
        roles.add(new Role(3L));

        User user = new User("Mostafizur", "Rahman", "mostafiz", passwordEncoder.encode("mostafiz"), "mostafiz.java8@gmail.com", true, null, roles);
        userRepo.save(user);

            Set<Role> roles2 = new HashSet<>();
            roles2.add(new Role(2L));
            roles2.add(new Role(3L));
            User user2 =  new User("sofiqul","Islam", "sofiq@gmail.com", "sofiq", passwordEncoder.encode("1234"),true,null, true, roles2);

        userRepo.save(user2);
        return "success";
    }*/

}
