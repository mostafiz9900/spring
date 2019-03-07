package com.beskilled.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String designationName;
private String shortDesignation;

    public Designation() {
    }

    public Designation(String designationName, String shortDesignation) {
        this.designationName = designationName;
        this.shortDesignation = shortDesignation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getShortDesignation() {
        return shortDesignation;
    }

    public void setShortDesignation(String shortDesignation) {
        this.shortDesignation = shortDesignation;
    }
}
