package com.beskilled;

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

    public void init() throws Exception {
        System.out.println("Start " + id);
    }
    public void close() throws Exception {
        System.out.println(" close the  " );
    }
}
