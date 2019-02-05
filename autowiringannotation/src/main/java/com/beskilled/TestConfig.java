package com.beskilled;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public Student StudentBean(){
        return new Student();
    }
@Bean
    public  StudentAddress studentAddressBean(){
        return new StudentAddress();
    }
}
