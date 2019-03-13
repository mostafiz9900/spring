package com.beskilled.repo;

import com.beskilled.entity.Floor;
import com.beskilled.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByFloor(Floor floor);
}
