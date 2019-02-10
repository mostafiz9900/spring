package com.beskilled.ropository;

import com.beskilled.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<User, Integer> {
}
