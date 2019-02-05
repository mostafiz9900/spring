package com.beskilled;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beanContext.xml");
        StudentAddress studentAddress= (StudentAddress) context.getBean("stuAdd");
        studentAddress.studentCall();
    }
}
