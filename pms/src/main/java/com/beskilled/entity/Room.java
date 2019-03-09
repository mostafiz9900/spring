package com.beskilled.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNo;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;




    public Room() {
    }

    public Room(String roomNo, Floor floor) {
        this.roomNo = roomNo;
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) &&
                Objects.equals(roomNo, room.roomNo) &&
                Objects.equals(floor, room.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNo, floor);
    }
}
