package com.beskilled.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String displayHome() {

        return "index";
    }

    @GetMapping(value = "/table")
    public String tabledisplay() {

        return "table";
    }

    @GetMapping(value = "/lay")
    public String layoutttt() {

        return "layout";
    }


}
