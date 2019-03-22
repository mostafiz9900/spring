package com.beskilled.controller;

import com.beskilled.entity.Product;
import com.beskilled.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository repo;
    @GetMapping(value = "/")
    public String view(){
        return "index";
    }

    @GetMapping(value = "/list")
    public String viewList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "/product/list-page";
    }

    @GetMapping(value = "/add")
    public String viewAdd(Product product){

        return "product/add-page";
    }
}
