package com.realestateapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApartmentRaterTest {


    @ParameterizedTest
    @CsvSource(value = {"72.00, 250000.00, 0", "48.00, 350000.00, 1", "30.00, 600000.00, 2"})
    void should_ReturnCorrectRating_When_CorrectApartment(double area, BigDecimal price, int rating) {
        Apartment apartment = new Apartment(area, price);

        int actualRating = ApartmentRater.rateApartment(apartment);

        assertEquals(rating, actualRating);
    }

    @Test
    void should_ReturnMinusOne_When_ApartmentAreaIsZero() {
        Apartment apartment = new Apartment(0.0, BigDecimal.valueOf(350000));

        int actualRating = ApartmentRater.rateApartment(apartment);

        assertEquals(-1, actualRating);
    }

    @Test
    void should_ReturnAverageRating_When_ApartmentListIsNotEmpty() {
        List<Apartment> apartments = new ArrayList<>();

        apartments.add(new Apartment(72.00, BigDecimal.valueOf(250000)));
        apartments.add(new Apartment(48.00, BigDecimal.valueOf(350000)));
        apartments.add(new Apartment(30.00, BigDecimal.valueOf(600000)));

        double expectedAverageRating = 1.0;

        double actualAverageRating = ApartmentRater.calculateAverageRating(apartments);

        assertEquals(expectedAverageRating, actualAverageRating);
    }

    @Test
    void should_ThrowRuntimeException_When_ApartmentListIsEmpty() {
        List<Apartment> apartments = new ArrayList<>();

        Executable actualAverageRating = () -> ApartmentRater.calculateAverageRating(apartments);

        assertThrows(RuntimeException.class, actualAverageRating);
    }
}