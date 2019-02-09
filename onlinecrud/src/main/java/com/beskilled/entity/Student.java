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
    private long id;
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

    public Student() {
    }

    public Student(String name, String email, String country, String sex, Date creteDate) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.sex = sex;
        this.creteDate = creteDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(email, student.email) &&
                Objects.equals(country, student.country) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(creteDate, student.creteDate);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, country, sex, creteDate);
    }
}
