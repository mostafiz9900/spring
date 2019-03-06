package com.beskilled.controller;

import com.beskilled.entity.Role;
import com.beskilled.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {
    @Autowired
    private RoleRepository repo;

     /* @GetMapping(value = "/role-save")
      public String saveRole(){
       Role role=new Role();
       role.setRoleName("SUPERADMIN");
       roleRepo.save(role);

          Role role2=new Role();
          role2.setRoleName("ADMIN");
          roleRepo.save(role2);


          Role role3=new Role();
          role3.setRoleName("USER");
          roleRepo.save(role3);

          return "success";
      }*/


    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("role",new Role());
        return "roles/add";
    }
    @PostMapping(value = "add")
    public String add(@Valid Role role, BindingResult result, Model model){
        if(result.hasErrors()){
            return "roles/add";
        }
        if(repo.existsRoleByRoleName(role.getRoleName())){
            model.addAttribute("rejectMsg","Already Have This Entry");
        }else{
            role.setRoleName(role.getRoleName().toUpperCase());
            this.repo.save(role);
            model.addAttribute("successMsg","Successfully Saved!");
        }

        return "roles/add";
    }
    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("role",repo.getOne(id));
        return "roles/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Role role, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            return "roles/edit";
        }
        Optional<Role> rol = this.repo.findByRoleName(role.getRoleName());
        if(rol.get().getId() != id){
            model.addAttribute("rejectMsg","Already Have This Entry");
            return "roles/edit";
        }else{
            role.setId(id);
            role.setRoleName(role.getRoleName().toUpperCase());
            this.repo.save(role);
        }

        return "redirect:/role/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/role/list";
    }

    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "roles/list";
    }
}
