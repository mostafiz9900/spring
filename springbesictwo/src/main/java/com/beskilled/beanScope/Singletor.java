package com.beskilled.beanScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
public class Singletor {
    public Singletor() {
        System.out.println("Single object");
    }
}
