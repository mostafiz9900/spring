package com.beskilled.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.*;


@Entity
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date startDate;
    private String toAddress;
    private String fromAddress;
    private String subject;
    private String body;
    private String end;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "meeting_officer", joinColumns =@JoinColumn(name = "meeting_id"),
    inverseJoinColumns = @JoinColumn(name = "officer_id"))
    private Set<User> users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organization organization;
    public Meeting() {
    }

    public Meeting(Date startDate, String toAddress, String fromAddress, String subject, String body, String end, Set<User> users, Organization organization) {
        this.startDate = startDate;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.subject = subject;
        this.body = body;
        this.end = end;
        this.users = users;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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
        Meeting meeting = (Meeting) o;
        return Objects.equals(id, meeting.id) &&
                Objects.equals(startDate, meeting.startDate) &&
                Objects.equals(toAddress, meeting.toAddress) &&
                Objects.equals(fromAddress, meeting.fromAddress) &&
                Objects.equals(subject, meeting.subject) &&
                Objects.equals(body, meeting.body) &&
                Objects.equals(end, meeting.end) &&
                Objects.equals(users, meeting.users) &&
                Objects.equals(organization, meeting.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, toAddress, fromAddress, subject, body, end, users, organization);
    }
}
