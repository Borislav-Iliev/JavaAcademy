package com.example.myapp.rest;

import com.example.myapp.common.Coach;
import com.example.myapp.common.SwimCoach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

    private final Coach coach;
    private final SwimCoach swimCoach;

    public SampleRestController(@Qualifier("cricketCoach") Coach coach, SwimCoach swimCoach) {
        this.coach = coach;
        this.swimCoach = swimCoach;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return this.coach.getDailyWorkout();
    }
}
