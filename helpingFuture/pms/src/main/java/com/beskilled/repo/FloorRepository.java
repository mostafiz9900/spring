package com.beskilled.repo;

import com.beskilled.entity.Bhaban;
import com.beskilled.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Long> {
    Floor findByBhaban(Bhaban bhaban);
}
