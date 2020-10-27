package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("when pass empty List<Integer> as a parametrer to exterminate() method, the same empty List<Integer> is returned ")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        System.out.println("Test Odd Numbers Exterminator Empty List.");
        //Given
        List<Integer> emptyList = new ArrayList<>();
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List<Integer> resultList = new ArrayList<>();
        resultList = oddNumbersExterminator.exterminate(emptyList);
        //Then
        Assertions.assertEquals(emptyList, resultList);
    }

    @DisplayName("when pass List<Integer> with even and odd numbers as a parameter to exterminate() method, List<Integer> with only odd numbers is returned")
    @Test
    void testOddNumbersExterminatorNormalList() {
        System.out.println("Test Odd Numbers Exterminator Normal List.");
        //Given
        List<Integer> testList = Arrays.asList(1, 2);
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(testList);
        //Then
        Assertions.assertTrue(resultList.contains(2) && !resultList.contains(1));
    }
}
