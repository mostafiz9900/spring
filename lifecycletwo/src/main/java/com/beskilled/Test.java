package com.beskilled;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //it makes program right coupling so not good
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("beanConfig.xml");

        Employee employee=(Employee)context.getBean("emp");
        System.out.println(employee);
        context.close();

    }
}
