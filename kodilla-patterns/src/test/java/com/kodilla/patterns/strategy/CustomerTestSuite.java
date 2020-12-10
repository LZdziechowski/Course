package com.kodilla.patterns.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTestSuite {

    @Test
    void testDefaultInvestingStrategies() {
        //Given
        Customer steven = new IndividualCustomer("Steven");
        Customer john = new IndividualYoungCustomer("John");
        Customer luk = new CorporateCustomer("Luk");
        //When
        String stevenShouldBuy = steven.predict();
        System.out.println(stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println(johnShouldBuy);
        String lukShouldBuy = luk.predict();
        System.out.println(lukShouldBuy);
        //Then
        assertEquals("[Conservative predictor] Buy debentures of XYZ", stevenShouldBuy);
        assertEquals("[Aggressive predictor] Buy stock of X", johnShouldBuy);
        assertEquals("[Balanced predictor] Buy shared units of Fund Y", lukShouldBuy);
    }

    @Test
    void testIndividualInvestingStrategy() {
        //Given
        Customer luk = new IndividualCustomer("Luk");
        //When
        String lukShouldBuy = luk.predict();
        System.out.println(lukShouldBuy);
        luk.setBuyingStrategy(new AggressivePredictor());
        lukShouldBuy = luk.predict();
        System.out.println(lukShouldBuy);
        //Then
        assertEquals("[Aggressive predictor] Buy stock of X", lukShouldBuy);
    }
}
