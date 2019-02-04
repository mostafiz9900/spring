package com.beskilled;

public class Depatment {
    private int depId;
    private String depName;
    private Address address;

    public Depatment(int depId, String depName, Address address) {
        this.depId = depId;
        this.depName = depName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Depatment{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", address=" + address +
                '}';
    }
}
