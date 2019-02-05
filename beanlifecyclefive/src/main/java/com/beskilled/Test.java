package com.beskilled;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.beskilled.EmployeeService;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean("employeeService", EmployeeService.class);
        context.close();
    }
}
