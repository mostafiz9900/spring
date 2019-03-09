package com.beskilled.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Objects;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orgName;
    private String ministryNameOrHeadOffice;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registrationDate;

    private String orgChiefName;
    private String phone;

    @Email
    @NotEmpty(message = "Enter An Email")
    @Column(nullable = false, unique = true)
    private String email;



    public Organization() {
    }


    public Organization(String orgName, String ministryNameOrHeadOffice, Date registrationDate, String orgChiefName, String phone, @Email @NotEmpty(message = "Enter An Email") String email) {
        this.orgName = orgName;
        this.ministryNameOrHeadOffice = ministryNameOrHeadOffice;
        this.registrationDate = registrationDate;
        this.orgChiefName = orgChiefName;
        this.phone = phone;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orgName, that.orgName) &&
                Objects.equals(ministryNameOrHeadOffice, that.ministryNameOrHeadOffice) &&
                Objects.equals(registrationDate, that.registrationDate) &&
                Objects.equals(orgChiefName, that.orgChiefName) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orgName, ministryNameOrHeadOffice, registrationDate, orgChiefName, phone, email);
    }
}
