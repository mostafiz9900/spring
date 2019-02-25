/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beSkilled;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * @author Mostafizur
 */
public class Hello {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @PostConstruct
    public void init(){
        System.out.println("before initializing bean-1");
    }
    
    @PreDestroy
     public void clear(){
        System.out.println("before destrouing  bean-1");
    }
    
}
