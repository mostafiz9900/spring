package com.beskilled.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Organigation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orgName;
    private String ministryNameOrHeadOffice;

    private Date registrationDate;

    private String orgChiefName;
    private String phone;
    private String email;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @ManyToOne
    @JoinColumn(name = "bhaban_id")
    private Bhaban bhaban;

}
