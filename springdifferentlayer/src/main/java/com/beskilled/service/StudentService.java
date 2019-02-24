package com.beskilled.service;

import com.beskilled.entity.Student;

import java.util.List;


public interface StudentService {
    void saveOrUpdate(Student student);

    void deleteById(Long id);

    Student findById(Long id);

    Student findByEmailAddres(String email);

    List<Student> getListAll();
}
