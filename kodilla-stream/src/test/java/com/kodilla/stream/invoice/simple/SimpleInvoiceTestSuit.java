package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleInvoiceTestSuit {

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
    void testGetValueToPay() {
        System.out.println("Test Get Value To Pay");
        //Given
        SimpleInvoice simpleInvoice = new SimpleInvoice();
        //When
        simpleInvoice.addItem(new SimpleItem(new SimpleProduct("Product 1", 17.28), 2));
        simpleInvoice.addItem(new SimpleItem(new SimpleProduct("Product 2", 11.99), 3.5));
        simpleInvoice.addItem(new SimpleItem(new SimpleProduct("Product 3", 6.49), 5));
        //Then
        assertEquals(108.975, simpleInvoice.getValueToPay(), 0.001);
    }
}
