package com.beskilled.sutowiring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class applicationConfig {
    public static void main(String[] args) {
       /* ConfigurableApplicationContext context= SpringApplication.run(applicationConfig.class, args);
        Employee employee=context.getBean(Employee.class);
        employee.showDetails();
*/
        ApplicationContext context2= new AnnotationConfigApplicationContext(TestConfig.class);
        Employee employee2=context2.getBean(Employee.class);
        employee2.showDetails();
    }
}
