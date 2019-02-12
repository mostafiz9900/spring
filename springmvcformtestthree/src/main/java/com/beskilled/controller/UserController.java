package com.beskilled.controller;

import com.beskilled.entity.User;
import com.beskilled.entity.UserRole;
import com.beskilled.imagoeptimizer.ImageOptimizer;
import com.beskilled.ropository.RoleRepo;
import com.beskilled.ropository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class UserController {
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";


    @Autowired
    private ImageOptimizer imageOptimizer;

    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;


    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "index";
    }

    @GetMapping(value = "/add")
    public String showAdd(User user, Model model) {
        model.addAttribute("roleList", this.roleRepo.findAll());

        return "add-page";
    }

    @PostMapping(value = "/add")
    public String save(@Valid User user, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "add-page";
        } else {
            user.setRegDate(new Date());
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                user.setFileName("new-" + file.getOriginalFilename());
                user.setFileSize(file.getSize());
                user.setFilePath("images/" + "new-" + file.getOriginalFilename());
                user.setFileExtension(file.getContentType());

                this.repo.save(user);
                model.addAttribute("user", new User());
                model.addAttribute("Msg", "Successfully data insert");

                imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.3f, 100, 100);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "add-page";
    }

    @GetMapping(value = "/edit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", this.repo.getOne(id));
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "edit-page";
    }

    @PostMapping(value = "/edit/{id}")
    public String edit(@Valid User user, BindingResult bindingResult, @PathVariable("id") Integer id, Model model, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "edit-page";
        } else {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                user.setFileName("new-" + file.getOriginalFilename());
                user.setFileSize(file.getSize());
                user.setFilePath("images/" + "new-" + file.getOriginalFilename());
                user.setFileExtension(file.getContentType());

                this.repo.save(user);
                model.addAttribute("user", new User());
                model.addAttribute("Msg2", "Successfully data insert");

                imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.3f, 100, 100);

            } catch (Exception e) {
                e.printStackTrace();
            }

            /*this.repo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("Msg2", "Successfully data insert");
*/
        }
        model.addAttribute("roleList", this.roleRepo.findAll());

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
