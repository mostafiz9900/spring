package com.beskilled;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public Student studentBean(){
        return new Student();
    }
    @Bean
    public StudentAddress studentAddressbean(){
        return new StudentAddress();

    }
}
