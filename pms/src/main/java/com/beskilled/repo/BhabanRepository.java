package com.beskilled.repo;

import com.beskilled.entity.Bhaban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BhabanRepository extends JpaRepository<Bhaban, Long> {
}
