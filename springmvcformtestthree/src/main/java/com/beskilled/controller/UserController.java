package com.beskilled.controller;

import com.beskilled.entity.User;
import com.beskilled.imagoeptimizer.ImageOptimizer;
import com.beskilled.ropository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class UserController {
   /* private static String UPLOADED_FOLDER = "D:/git/myGit/spring/springmvcformtestthree/src/main/redirect/static/images";


    @Autowired
    private ImageOptimizer imageOptimizer;
*/
    @Autowired
    private UserRepo repo;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "index";
    }

    @GetMapping(value = "/add")
    public String showAdd(User user) {
        return "add-page";
    }

    @PostMapping(value = "/add")
    public String save(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-page";
        } else {
            user.setRegDate(new Date());
            this.repo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("Msg", "Successfully data insert");

        }
        return "add-page";

    }

    @GetMapping(value = "/edit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", this.repo.getOne(id));
        return "edit-page";

    }

    @PostMapping(value = "/edit/{id}")
    public String edit(@Valid User user, BindingResult bindingResult, @PathVariable("id") Integer id, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit-page";
        } else {
            this.repo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("Msg2", "Successfully data insert");
        }

        return "edit-page";
    }

    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if (id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/";
    }

}
