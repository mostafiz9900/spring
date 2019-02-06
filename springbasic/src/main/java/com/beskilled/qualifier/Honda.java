package com.beskilled.qualifier;

import org.springframework.stereotype.Component;

@Component(value = "hondaBean")
public class Honda implements Vehicle {

    @Override
    public void start() {
        System.out.println("start honda");

    }

    @Override
    public void stop() {
        System.out.println("stop honda");

    }
}
