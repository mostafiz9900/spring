package com.beskilled.dao;

import com.beskilled.entity.Student;
import com.beskilled.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentDAO {
    @Autowired
    private  StudentRepo repo;

    /*to save an employee*/

    public Student save(Student std) {
        return repo.save(std);
    }


    /* search all employees*/

    public List<Student> findAll(){
        return repo.findAll();
    }


    /*get an employee by id*/
   /* public Student findOnes(Long id) {
        return repo.findOne(id);
    }*/


    /*delete an employee*/

    public void delete(Student std) {
        repo.delete(std);
    }
}
