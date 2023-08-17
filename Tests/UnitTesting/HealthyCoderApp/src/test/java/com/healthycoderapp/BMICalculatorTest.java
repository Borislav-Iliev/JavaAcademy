package com.healthycoderapp;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {


    @Nested
    class IsDietRecommendedTests {
        @ParameterizedTest(name = "weight={0}, height={1}")
        @CsvSource(value = {"89.00, 1.72", "95.00, 1.75", "110.00, 1.78"})
        void should_ReturnTrue_When_DietRecommended(Double coderWeight, Double coderHeight) {
            double weight = coderWeight;
            double height = coderHeight;

            boolean result = BMICalculator.isDietRecommended(weight, height);

            assertTrue(result);
        }

        @Test
        void should_ReturnFalse_When_DietNotRecommended() {
            double weight = 50;
            double height = 1.92;

            boolean result = BMICalculator.isDietRecommended(weight, height);

            assertFalse(result);
        }

        @Test
        void should_ThrowArithmeticException_When_HeightIsZero() {
            double weight = 50;
            double height = 0.0;

            Executable result = () -> BMICalculator.isDietRecommended(weight, height);

            assertThrows(ArithmeticException.class, result);
        }
    }

    @Nested
    class FindCoderWithWorstBMITests {
        @Test
        void should_ReturnCoderWithWorstBMI_When_CoderListIsNotEmpty() {
            List<Coder> coders = new ArrayList<>();

            coders.add(new Coder(1.80, 61.00));
            coders.add(new Coder(1.82, 99.00));
            coders.add(new Coder(1.82, 65.7));

            Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

            assertAll(
                    () -> assertEquals(1.82, coderWithWorstBMI.getHeight()),
                    () -> assertEquals(99.00, coderWithWorstBMI.getWeight())
            );
        }

        @Test
        void should_ReturnCoderWithWorstBMIIn1Ms_When_CoderListHas10000Elements() {
            List<Coder> coders = new ArrayList<>();

            for (int i = 0; i < 10000; i++) {
                coders.add(new Coder(1.00 + i, 10.00 + i));
            }

            Executable coderWithWorstBMI = () -> BMICalculator.findCoderWithWorstBMI(coders);

            assertTimeout(Duration.ofMillis(500), coderWithWorstBMI);
        }

        @Test
        void should_ReturnNull_When_CoderListNotEmpty() {
            List<Coder> coders = new ArrayList<>();

            Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

            assertNull(coderWithWorstBMI);
        }
    }

    @Nested
    class getBMIScoresTests {
        @Test
        void should_ReturnCorrectBMIScoreArray_WhenCoderListIsNotEmpty() {
            List<Coder> coders = new ArrayList<>();

            coders.add(new Coder(1.80, 61.00));
            coders.add(new Coder(1.82, 99.00));
            coders.add(new Coder(1.82, 65.7));

            double[] expectedBMIs = {18.83, 29.89, 19.83};

            double[] bmiScores = BMICalculator.getBMIScores(coders);

            assertArrayEquals(expectedBMIs, bmiScores);
        }
    }
}