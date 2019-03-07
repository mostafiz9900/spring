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



    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

}
