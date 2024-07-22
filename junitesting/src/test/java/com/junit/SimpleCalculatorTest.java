package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SimpleCalculatorTest {
    @Test
    void twoPlusTwoShouldEqualFour() {
        SimpleCalculator sc = new SimpleCalculator(); 
        assertEquals(4, sc.add(2, 2)); 
    }

    @Test
    void threePlusSevenShouldEqualTen() {
        SimpleCalculator sc = new SimpleCalculator(); 
        assertEquals(10, sc.add(3, 7)); 
    }
}
