package com.beskilled.ropository;

import com.beskilled.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<UserRole, Integer> {
    UserRole findByRoleName(String roleName);
}
