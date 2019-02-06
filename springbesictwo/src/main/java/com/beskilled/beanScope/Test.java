package com.beskilled.beanScope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Test.class, args);
        com.beskilled.beanScope.Singletor aa = context.getBean(com.beskilled.beanScope.Singletor.class);
        com.beskilled.beanScope.Singletor aa2 = context.getBean(com.beskilled.beanScope.Singletor.class);
        //One or More object call and print
        com.beskilled.beanScope.More bb = context.getBean(com.beskilled.beanScope.More.class);
        com.beskilled.beanScope.More bb2 = context.getBean(com.beskilled.beanScope.More.class);
        com.beskilled.beanScope.More bb3 = context.getBean(com.beskilled.beanScope.More.class);
    }
}