package com.beskilled.dianotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StudentConfig {
    @Bean(name = "student")
    public Student getStudent() {
        Student student = new Student(100, "mostafiz");
        return student;

    }
    @Bean(name = "student2")
    public Student getStudentSetter(){
        Student student=new Student();
        student.setId(200);
        student.setName("Mostafizur");
        return student;
    }
}

