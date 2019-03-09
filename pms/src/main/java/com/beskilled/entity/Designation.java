package com.beskilled.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String designationName;
private String shortDesignation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "org_id")
    private Organization organization;

    public Designation() {
    }

    public Designation(String designationName, String shortDesignation, Organization organization) {
        this.designationName = designationName;
        this.shortDesignation = shortDesignation;
        this.organization = organization;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Designation that = (Designation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(designationName, that.designationName) &&
                Objects.equals(shortDesignation, that.shortDesignation) &&
                Objects.equals(organization, that.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designationName, shortDesignation, organization);
    }
}
