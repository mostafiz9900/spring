/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beSkilled;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Mostafizur
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/beSkilled/applicationContex.xml");
        Hello hello = (Hello) context.getBean("h");
        hello.setMessage("Hello Spring");
        System.out.println(hello.getMessage());

        ApplicationContext context2 = new AnnotationConfigApplicationContext(applicationConfig.class);
        Hello hello2 = (Hello) context2.getBean("hello");
        hello2.setMessage("Hello 2 Spring e");
        System.out.println(hello2.getMessage());

    }

}
