package com.beskilled.beanScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class More {
    public More() {
        System.out.println("More object print..");
    }
}
