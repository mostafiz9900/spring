package com.beskilled.hellomvctwo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    /*@GetMapping(value = "/tt/{msg}")
    public String test(@PathVariable("msg") String msg){
        return msg;
    }*/
    @GetMapping(value = "/tt")
    public String test(@RequestParam(value = "ms" , required = true,defaultValue = "mostafiz") String msg){
        return msg;

    }
    //call http://localhost:8008/tt?ms=flfjlsjf
}
