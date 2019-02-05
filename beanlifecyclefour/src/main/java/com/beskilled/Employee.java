package com.beskilled;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee {
    private int id;
    private String position;

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }

    @PostConstruct
    public void initIt() {
        System.out.println("Init method after proparti" + id + " " + position);
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("Employee end of the work");
    }

}
