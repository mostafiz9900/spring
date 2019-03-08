package com.beskilled.repo;

import com.beskilled.entity.Bhaban;
import com.beskilled.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
