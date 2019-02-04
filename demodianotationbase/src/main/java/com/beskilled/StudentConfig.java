package com.beskilled;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean(name = "student")
    public Student getStudent() {
        Student student = new Student(100, "Mostafizur");

        return student;
    }
@Bean(name = "student2")
    public Student getStudetSetter() {
        Student stu=new Student();
    stu.setId(101);
    stu.setName("Mostafizur Rahman");

        return stu;
    }
}
