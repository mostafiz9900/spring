package com.beskilled;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee= (Employee) context.getBean("simpleServ");
        employee.printNameId();
        System.out.println(".......................");
        try {
            employee.checkName();
        }catch (Exception e){
            System.out.println("Employee name check method throw exception");
        }
        System.out.println("///////////////////");
        employee.sayHello("wow very nice");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
