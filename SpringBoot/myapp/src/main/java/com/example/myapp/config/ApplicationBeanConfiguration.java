package com.example.myapp.config;

import com.example.myapp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public SwimCoach swimCoach() {
        return new SwimCoach();
    }
}
