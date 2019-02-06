package com.beskilled.beanScope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Test.class, args);
        com.beskilled.beanScope.Singleton a1 = context.getBean(com.beskilled.beanScope.Singleton.class);
        com.beskilled.beanScope.Singleton a2 = context.getBean(com.beskilled.beanScope.Singleton.class);


        com.beskilled.beanScope.More b1 = context.getBean(com.beskilled.beanScope.More.class);
        com.beskilled.beanScope.More b2 = context.getBean(com.beskilled.beanScope.More.class);

        com.beskilled.beanScope.More b3 = context.getBean(com.beskilled.beanScope.More.class);

    }
}
