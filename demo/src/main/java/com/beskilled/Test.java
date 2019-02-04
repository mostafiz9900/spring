package com.beskilled;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
    public static void main(String[] args) {
        Resource r=new ClassPathResource("applicationContext.xml");
        BeanFactory factory=new XmlBeanFactory(r);
        Address address= (Address) factory.getBean("a1");
        System.out.println(address);

        Student student= (Student) factory.getBean("stu");
        System.out.println(student);

    }
}
