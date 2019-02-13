package com.beskilled;

public class Employee {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printNameId() {
        System.out.println("SimpleService : Method printNameId() : My name is " + name + " and my id is " + id);
    }

    public void checkName() {
        if (name.length() < 20) {
            throw new IllegalArgumentException();
        }
    }

    public void sayHello(String message) {
        System.out.println("SimpleService : Method sayHello() : Hello! " + message);
    }
}
