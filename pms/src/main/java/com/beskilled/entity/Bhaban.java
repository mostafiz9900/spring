package com.beskilled.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Bhaban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bhabanName;
    private String address;

    public Bhaban() {
    }

    public Bhaban(String bhabanName, String address) {
        this.bhabanName = bhabanName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBhabanName() {
        return bhabanName;
    }

    public void setBhabanName(String bhabanName) {
        this.bhabanName = bhabanName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bhaban bhaban = (Bhaban) o;
        return Objects.equals(id, bhaban.id) &&
                Objects.equals(bhabanName, bhaban.bhabanName) &&
                Objects.equals(address, bhaban.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bhabanName, address);
    }
}
