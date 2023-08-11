package com.example.aopexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

@SpringBootApplication(exclude = {JmxAutoConfiguration.class})
public class AopExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopExampleApplication.class, args);
    }

}
