package com.beskilled.qualifier;

import org.springframework.stereotype.Component;

@Component(value = "hondaBean")

public class Honda implements Vehicle {
    @Override
    public void start() {
        System.out.println("Start honda driving..");

    }

    @Override
    public void stop() {
        System.out.println("Stop honda driving .....");
    }
}
