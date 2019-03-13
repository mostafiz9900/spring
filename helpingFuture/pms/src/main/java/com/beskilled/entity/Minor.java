package com.beskilled.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "minor")
public class Minor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String meetingTitle;
    private String agendaAction;
    private String remark;



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;


    public Minor() {
    }

    public Minor(String meetingTitle, String agendaAction, String remark, Meeting meeting) {
        this.meetingTitle = meetingTitle;
        this.agendaAction = agendaAction;
        this.remark = remark;
        this.meeting = meeting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public String getAgendaAction() {
        return agendaAction;
    }

    public void setAgendaAction(String agendaAction) {
        this.agendaAction = agendaAction;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minor minor = (Minor) o;
        return Objects.equals(id, minor.id) &&
                Objects.equals(meetingTitle, minor.meetingTitle) &&
                Objects.equals(agendaAction, minor.agendaAction) &&
                Objects.equals(remark, minor.remark) &&
                Objects.equals(meeting, minor.meeting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, meetingTitle, agendaAction, remark, meeting);
    }
}
