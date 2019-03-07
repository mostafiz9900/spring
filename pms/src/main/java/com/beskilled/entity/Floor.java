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

    public Floor() {
    }

    public Floor(String floorName, Bhaban bhaban) {
        this.floorName = floorName;
        this.bhaban = bhaban;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Bhaban getBhaban() {
        return bhaban;
    }

    public void setBhaban(Bhaban bhaban) {
        this.bhaban = bhaban;
    }
}
