package com.beskilled;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;

public class EmployeeService implements ApplicationContextAware, ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware, BeanNameAware, EnvironmentAware, ImportAware, ResourceLoaderAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader");
        System.out.println("setBeanClassLoader:: class loader===" + classLoader.getClass().getName());

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory call");
        System.out.println("setBeanFactory:: employee ==" + beanFactory.isSingleton("employee"));

    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("setBeanName called");
        System.out.println("setBeanName:: set bean name definition context====" + beanName);

    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("setApplicationContext");
        System.out.println("setApplicationContext:: Bran name definition in context=== =" + Arrays.toString(context.getBeanDefinitionNames()));

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("setApplicationEventPublisher call");

    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("setEnvironment");

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("setResourceLoader");
        Resource resource = resourceLoader.getResource("classpath:sprint.xml");
        System.out.println("setResourceLoader:: Resource file name ====" + resource.getFilename());

    }

    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        System.out.println("setImportMetadata");

    }
}
