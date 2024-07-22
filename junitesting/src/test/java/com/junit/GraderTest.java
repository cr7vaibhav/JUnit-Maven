package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GraderTest {
    @Test
    void fiftyNineShouldReturnF() {
        var grader = new Grader();
        assertEquals('F', grader.determineLetterGrade(59));
    }

    @Test
    void sixtyNineShouldReturnD() {
        var grader = new Grader();
        assertEquals('D', grader.determineLetterGrade(69));
    }

    @Test
    void seventyNineShouldReturnC() {
        var grader = new Grader();
        assertEquals('C', grader.determineLetterGrade(79));
    }

    @Test
    void eightyNineShouldReturnB() {
        var grader = new Grader();
        assertEquals('B', grader.determineLetterGrade(89));
    }

    @Test
    void ninetyNineShouldReturnA() {
        var grader = new Grader();
        assertEquals('A', grader.determineLetterGrade(99));
    }

    @Test
    void ninetyShouldReturnA() {
        var grader = new Grader();
        assertEquals('A', grader.determineLetterGrade(90));
    }

    @Test
    void eightyShouldReturnB() {
        var grader = new Grader();
        assertEquals('B', grader.determineLetterGrade(80));
    }

    @Test
    void seventyShouldReturnC() {
        var grader = new Grader();
        assertEquals('C', grader.determineLetterGrade(70));
    }

    @Test
    void sixtyShouldReturnD() {
        var grader = new Grader();
        assertEquals('D', grader.determineLetterGrade(60));
    }

    @Test
    void zeroShouldReturnF() {
        var grader = new Grader();
        assertEquals('F', grader.determineLetterGrade(0));
    }

    @Test
    void negativeOneShouldReturnIllegalArgumentException() {
        var grader = new Grader();
        assertThrows(IllegalArgumentException.class,
                () -> grader.determineLetterGrade(-1));
        // assertThrows expects two parameters the first one is the
        // exception class and the second one is lambda function with
        // the code that throws the exception

    }
}
