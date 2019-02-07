package com.beskilled.hellomvctwo.Controller;

import com.beskilled.hellomvctwo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    static List<Student> list;
    static {
        list=new ArrayList<>();
        list.add(new Student(1, "Mostafiz", "mosta@gmail.com"));
        list.add(new Student(2, "Mahabub", "mahabub@gmail.com"));
        list.add(new Student(3, "Sofiqul", "sofiq@gmail.com"));
        list.add(new Student(4, "ajat", "ajat@gmail.com"));
    }
    @GetMapping(value = "/lists")
    public List<Student> getList(){
        return this.list;
    }
   /* @GetMapping(value = "/userid/{id}")
    public List<Student> getIdByList(@PathVariable("id" Ineger userId)){
        Student student=null;
        for (Student s: list){
            if (userId==s.getId() ){
                student=new Student();

            }
        }

        return list;
    }*/

}
