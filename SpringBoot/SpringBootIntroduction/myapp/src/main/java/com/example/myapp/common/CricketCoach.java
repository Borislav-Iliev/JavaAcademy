package com.example.myapp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Post Construct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
