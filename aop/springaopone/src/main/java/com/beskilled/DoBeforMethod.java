package com.beskilled;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class DoBeforMethod implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Spring Apo doBefor Methode");
    }
}
