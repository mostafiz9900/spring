package com.beskilled.entity;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomNo;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

}
