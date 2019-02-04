package com.beskilled;

public class Address {
    private int addId;
    private String city;
    private String country;
    private Student student;

    public Address(int addId, String city, String country, Student student) {
        this.addId = addId;
        this.city = city;
        this.country = country;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addId=" + addId +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", student=" + student +
                '}';
    }
}
