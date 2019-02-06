package com.beskilled.beanScope;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
public class Singleton {
    public Singleton() {
        System.out.println("Singleton object");
    }
}
