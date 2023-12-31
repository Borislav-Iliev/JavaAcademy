package com.healthycoderapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest {

    private DietPlanner dietPlanner;

    @BeforeEach
    void setUp() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void afterEach() {
        System.out.println("A unit test was finished");
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expectedDietPlan = new DietPlan(2202, 110, 73, 275);

        DietPlan actualDietPlan = this.dietPlanner.calculateDiet(coder);

        assertAll(
                () ->   assertEquals(expectedDietPlan.getCalories(), actualDietPlan.getCalories()),
                () ->   assertEquals(expectedDietPlan.getProtein(), actualDietPlan.getProtein()),
                () ->   assertEquals(expectedDietPlan.getFat(), actualDietPlan.getFat()),
                () ->   assertEquals(expectedDietPlan.getCarbohydrate(), actualDietPlan.getCarbohydrate())
        );
    }
}