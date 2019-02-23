package com.beskilled.controller;

import com.beskilled.entity.User;
import com.beskilled.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private UserRepository repo;
    @ResponseBody
    @GetMapping(value = "/test")
    public User testRepo(){

        return this.repo.findByUsernameOrPassword("mostafiz","");
    }
}
