package com.beskilled.serviceImpl;

import com.beskilled.entity.Student;
import com.beskilled.repository.StudentRepo;
import com.beskilled.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepo repo;
    @Override
    public void saveOrUpdate(Student student) {
        repo.save(student);

    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);

    }

    @Override
    public Student findById(Long id) {
        return repo.getOne(id);
    }

    @Override
    public Student findByEmailAddres(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public List<Student> getListAll() {
        List<Student> list=new ArrayList<>();
        return list;
    }
}
