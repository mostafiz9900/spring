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


}
