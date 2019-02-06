package com.beskilled.showautowiring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        /*
        ConfigurableApplicationContext context= SpringApplication.run(Test.class, args);
        Employee employee=context.getBean(Employee.class);
        employee.showDetails();
        */
        ApplicationContext context=new AnnotationConfigApplicationContext(TestConfig.class);
        Employee employee=context.getBean(Employee.class);
        employee.showDetails();
    }
}
