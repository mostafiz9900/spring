package com.beskilled;


import org.springframework.aop.ThrowsAdvice;

public class DoAfterThrowing implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("****SPRING AOP**** DoAfterThrowingExceptionMethod : Executing when method throws exception!");
    }
}
