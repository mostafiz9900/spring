package com.beskilled.entity;

import javax.persistence.*;

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
}
