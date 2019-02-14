package com.beskilled.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class indexController {

    @RequestMapping("/")
    public String home(Map<String, Object> map){
        map.put("message", "Hello spring ");
        return "index";

    }
    @RequestMapping("/next")
    public String nextPage(Map<String, Object> map){
        map.put("message", "Your new Page ");
        return "next";

    }
}
