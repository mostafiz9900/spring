package com.beskilled.Cars;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("CarContext.xml");
        Vehicle vehicle= (Vehicle) context.getBean("car");
        vehicle.drive();
    }
}
