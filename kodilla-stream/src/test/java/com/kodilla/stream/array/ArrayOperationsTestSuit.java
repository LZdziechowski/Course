package com.kodilla.stream.array;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class ArrayOperationsTestSuit {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Beginning of tests.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    void testGetAverage() {
        System.out.println("Test get avrage");
        //Given
        final int[] numbersTab = {14, 2, 1, 4, 7, 3, 9, 7, 1, 3};
        //When
        final double calculatedAverage = ArrayOperations.getAverage(numbersTab);
        //Then
        final double expectedAverage = 5.1;
        assertEquals(expectedAverage, calculatedAverage);
    }
}
