package com.beskilled.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 3, max = 30)
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String country;
    @NotEmpty
    private String sex;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date creteDate;


    @NotEmpty
    private String section;

    public Student() {
    }

    public Student(@Size(min = 3, max = 30) String name, @NotBlank String email, @NotBlank String country, @NotEmpty String sex, Date creteDate, @NotEmpty String section) {

        this.name = name;
        this.email = email;
        this.country = country;
        this.sex = sex;
        this.creteDate = creteDate;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreteDate() {
        return creteDate;
    }

    public void setCreteDate(Date creteDate) {
        this.creteDate = creteDate;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
