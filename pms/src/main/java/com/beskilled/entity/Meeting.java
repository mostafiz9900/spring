package com.beskilled.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private String to;
    private String form;
    private String subject;
    private String body;
    private String end;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "officer_id")
    private User officer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "org_id")
    private Organization organization;

    public Meeting() {
    }

    public Meeting(Date startDate, String to, String form, String subject, String body, String end, User officer, Organization organization) {
        this.startDate = startDate;
        this.to = to;
        this.form = form;
        this.subject = subject;
        this.body = body;
        this.end = end;
        this.officer = officer;
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

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
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

    public User getOfficer() {
        return officer;
    }

    public void setOfficer(User officer) {
        this.officer = officer;
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
                Objects.equals(to, meeting.to) &&
                Objects.equals(form, meeting.form) &&
                Objects.equals(subject, meeting.subject) &&
                Objects.equals(body, meeting.body) &&
                Objects.equals(end, meeting.end) &&
                Objects.equals(officer, meeting.officer) &&
                Objects.equals(organization, meeting.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, to, form, subject, body, end, officer, organization);
    }
}
