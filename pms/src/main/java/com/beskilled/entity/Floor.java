package com.beskilled.entity;

import javax.persistence.*;

@Entity
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String floorName;


@ManyToOne
@JoinColumn(name = "bhaban_id")
    private Bhaban bhaban;
}
