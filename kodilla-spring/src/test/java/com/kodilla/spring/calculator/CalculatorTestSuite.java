package com.kodilla.spring.calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    private static int testCounter = 0;

    @Autowired
    private Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Beginning of tests.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing to execute test: #" + testCounter);
    }

    @Test
    void testCalculations() {
        System.out.println("Test Calculations");
        //Given
        final double firstNumber = 2;
        final double secondNumber = 5;
        final double zero = 0;
        //When & Then
        assertAll(
                () -> assertEquals(7,calculator.add(firstNumber, secondNumber)),
                () -> assertEquals(-3, calculator.sub(firstNumber, secondNumber)),
                () -> assertEquals(10, calculator.mul(firstNumber, secondNumber)),
                () -> assertEquals(0.4, calculator.div(firstNumber, secondNumber)),
                () -> assertThrows(DivisionByZeroException.class, () -> calculator.div(firstNumber, zero))
        );
    }
}
