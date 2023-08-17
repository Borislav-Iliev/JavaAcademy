package com.realestateapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RandomApartmentGeneratorTest {

    private static final double MAX_MULTIPLIER = 4.0;

    private RandomApartmentGenerator defaultRandomApartmentGenerator;

    private RandomApartmentGenerator customRandomApartmentGenerator;
    private static final double AREA = 15.0;
    private static final BigDecimal MIN_PRICE_PER_SQUARE_METER = BigDecimal.valueOf(5000.00);

    @BeforeEach
    void setUp() {
        this.defaultRandomApartmentGenerator = new RandomApartmentGenerator();
        this.customRandomApartmentGenerator = new RandomApartmentGenerator(AREA, MIN_PRICE_PER_SQUARE_METER);
    }

    @Test
    void should_ReturnCorrectApartment_When_DefaultMinAreaAndMinPricePerSquareMeter() {
        double minArea = 30.00;
        double maxArea = minArea * MAX_MULTIPLIER;

        BigDecimal minPricePerSquareMeter = BigDecimal.valueOf(3000.0);
        BigDecimal maxPricePerSquareMeter = minPricePerSquareMeter.multiply(BigDecimal.valueOf(MAX_MULTIPLIER));

        Apartment expectedApartment = this.defaultRandomApartmentGenerator.generate();

        BigDecimal apartmentMinPrice = BigDecimal.valueOf(expectedApartment.getArea()).multiply(minPricePerSquareMeter);
        BigDecimal apartmentMaxPrice = BigDecimal.valueOf(expectedApartment.getArea()).multiply(maxPricePerSquareMeter);

        assertAll(
                () -> assertTrue(expectedApartment.getArea() >= minArea),
                () -> assertTrue(expectedApartment.getArea() <= maxArea),
                () -> assertTrue(expectedApartment.getPrice().compareTo(apartmentMinPrice) >= 0),
                () -> assertTrue(expectedApartment.getPrice().compareTo(apartmentMaxPrice) <= 0)
        );
    }

    @Test
    void should_ReturnCorrectApartment_When_CustomMinAreaAndMinPricePerSquareMeter() {
        double minArea = AREA;
        double maxArea = minArea * MAX_MULTIPLIER;

        BigDecimal minPricePerSquareMeter = MIN_PRICE_PER_SQUARE_METER;
        BigDecimal maxPricePerSquareMeter = minPricePerSquareMeter.multiply(BigDecimal.valueOf(MAX_MULTIPLIER));

        Apartment expectedApartment = this.customRandomApartmentGenerator.generate();

        BigDecimal apartmentMinPrice = BigDecimal.valueOf(expectedApartment.getArea()).multiply(minPricePerSquareMeter);
        BigDecimal apartmentMaxPrice = BigDecimal.valueOf(expectedApartment.getArea()).multiply(maxPricePerSquareMeter);

        assertAll(
                () -> assertTrue(expectedApartment.getArea() >= minArea),
                () -> assertTrue(expectedApartment.getArea() <= maxArea),
                () -> assertTrue(expectedApartment.getPrice().compareTo(apartmentMinPrice) >= 0),
                () -> assertTrue(expectedApartment.getPrice().compareTo(apartmentMaxPrice) <= 0)
        );
    }
}