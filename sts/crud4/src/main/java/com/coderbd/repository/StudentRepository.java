package com.coderbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderbd.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
