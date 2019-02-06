package com.beskilled.qualifier;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.beskilled.qualifier");
        context.refresh();
        VehicleService service = context.getBean(VehicleService.class);
        service.service();
        context.close();
    }
}
