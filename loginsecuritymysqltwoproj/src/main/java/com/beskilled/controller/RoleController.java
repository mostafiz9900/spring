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
import java.util.Set;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {
    @Autowired
    private RoleRepository roleRepo;

    /*  @GetMapping(value = "/save-role")
      public String saveRole(){
       Role role=new Role();
       role.setRoleName("ADMIN");
       roleRepo.save(role);

          Role role2=new Role();
          role2.setRoleName("SUPERADMIN");
          roleRepo.save(role2);


          Role role3=new Role();
          role3.setRoleName("USER");
          roleRepo.save(role3);

          return "success";
      }*/
    @GetMapping(value = "view-role")
    public String viewrole(Model model) {
        model.addAttribute("listrole", this.roleRepo.findAll());
        return "role/role-view";

    }

    @GetMapping(value = "save-role")
    public String addViwe(Role role) {

        return "role/role-add";

    }

    @PostMapping(value = "save-role")
    public String addRole(@Valid Role role, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "role/role-add";
        }
        if (role != null) {
            Role role2 = this.roleRepo.findByRoleName(role.getRoleName());
            if (role2 != null) {
                model.addAttribute("existMsg", "RoleName is already exist");
            } else {
                role.setRoleName(role.getRoleName().toUpperCase());
                this.roleRepo.save(role);
                model.addAttribute("role", new Role());
                model.addAttribute("successRole", "Role insert data");
            }
        }

        return "role/role-add";

    }

    @GetMapping(value = "edit-role/{id}")
    public String editviwerole(@PathVariable("id") Long id, Model model) {
        model.addAttribute("role", this.roleRepo.getOne(id));
        return "role/role-edit";

    }

    @PostMapping(value = "edit-role/{id}")
    public String editRole(@Valid Role role, @PathVariable("id") Long id, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "role/role-add";
        }
        role.setRoleName(role.getRoleName().toUpperCase());
        this.roleRepo.save(role);


        return "redirect:/role/view-role";

    }

    @RequestMapping(value = "delrole/{id}", method = RequestMethod.GET)
    public String deleteRole(@PathVariable("id") Long id) {
        if (id != null) {
            this.roleRepo.deleteById(id);
        }
        return "redirect:/role/view-role";
    }

}
