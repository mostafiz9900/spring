package com.beskilled;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        Student stu = (Student) context.getBean("student");
        System.out.println(stu);

        Student stu2 = (Student) context.getBean("student2");
        System.out.println(stu2);

    }
}
