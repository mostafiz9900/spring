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

    public Organigation() {
    }

    public Organigation(String orgName, String ministryNameOrHeadOffice, Date registrationDate, String orgChiefName, String phone, String email, Room room, Floor floor, Bhaban bhaban) {
        this.orgName = orgName;
        this.ministryNameOrHeadOffice = ministryNameOrHeadOffice;
        this.registrationDate = registrationDate;
        this.orgChiefName = orgChiefName;
        this.phone = phone;
        this.email = email;
        this.room = room;
        this.floor = floor;
        this.bhaban = bhaban;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getMinistryNameOrHeadOffice() {
        return ministryNameOrHeadOffice;
    }

    public void setMinistryNameOrHeadOffice(String ministryNameOrHeadOffice) {
        this.ministryNameOrHeadOffice = ministryNameOrHeadOffice;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getOrgChiefName() {
        return orgChiefName;
    }

    public void setOrgChiefName(String orgChiefName) {
        this.orgChiefName = orgChiefName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Bhaban getBhaban() {
        return bhaban;
    }

    public void setBhaban(Bhaban bhaban) {
        this.bhaban = bhaban;
    }
}
