package com.beskilled.dao;

import com.beskilled.entity.Student;
import com.beskilled.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDAO {
    @Autowired
    StudentRepo studentRepo;
    public Student save(Student std) {
        return studentRepo.save(std);
    }
    public void delete(Student std){
        studentRepo.delete(std);
    }
    public List<Student> list(){
        return studentRepo.findAll();
    }
    /*get an employee by id*/
    /*public Student findOne(Long id) {
        return studentRepo.findById(id);
    }*/
}
