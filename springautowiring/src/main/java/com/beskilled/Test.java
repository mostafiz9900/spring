package com.beskilled;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        TextEditor textEditor = (TextEditor) context.getBean("edite");
        textEditor.spellCheck();
    }
}
