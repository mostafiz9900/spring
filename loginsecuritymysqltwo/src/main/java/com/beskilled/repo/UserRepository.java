package com.beskilled.repo;

import com.beskilled.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>  findByUsernameOrEmail(String username, String email);
    User findByUsername(String username);
    User findByUsernameOrPassword(String username, String password);
}
