package com.example.myapp.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor:" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 metres as a warm up";
    }
}
