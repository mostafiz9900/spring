package com.beskilled.entity;

public class User {
    private long id;
    private String userName;
    private String mobail;

    public User() {

    }

    public User(long id, String userName, String mobail) {
        this.id = id;
        this.userName = userName;
        this.mobail = mobail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobail() {
        return mobail;
    }

    public void setMobail(String mobail) {
        this.mobail = mobail;
    }
}
