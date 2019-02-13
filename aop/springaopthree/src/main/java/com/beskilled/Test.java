package com.beskilled;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee = (Employee) context.getBean("simpleProxy");
        employee.printNameId();
        System.out.println("..........................");
        try {
            employee.checkName();
        } catch (Exception e) {
            System.out.println("This Method some logic exception");
        }
        employee.sayHello("pring sayHello Method");
        ((ClassPathXmlApplicationContext) context).close();
    }
}
