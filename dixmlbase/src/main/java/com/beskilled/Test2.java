package com.beskilled;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test2 {
    public static void main(String[] args) {
        Resource resource=new ClassPathResource("applicationContextSetter.xml");
        BeanFactory factory=new XmlBeanFactory(resource);
        Rge rge= (Rge) factory.getBean("reg");
        System.out.println(rge);
    }
}
