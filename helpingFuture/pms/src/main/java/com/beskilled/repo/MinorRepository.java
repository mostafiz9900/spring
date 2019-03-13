package com.beskilled.repo;

import com.beskilled.entity.Minor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinorRepository extends JpaRepository<Minor, Long> {
}
