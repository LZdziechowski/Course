package com.kodilla.stream.world;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

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
    void testGetPeopleQuantity() {
        System.out.println("Test get people quantity");
        //Given
        final World world = new World();
        final Continent europe = new Continent("Europe");
        final Continent asia = new Continent("Asia");
        final Continent africa = new Continent("Africa");
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        final Country poland = new Country("Poland", new BigDecimal("38386000"));
        final Country italy = new Country("Italy", new BigDecimal("60483973"));
        final Country spain = new Country("Spain", new BigDecimal("47100396"));
        final Country japan = new Country("Japan", new BigDecimal("125396901"));
        final Country china = new Country("China", new BigDecimal("1420000000"));
        final Country india = new Country("India", new BigDecimal("1296384042"));
        final Country egypt = new Country("Egypt", new BigDecimal("100000408"));
        final Country kenya = new Country("Kenya", new BigDecimal("47654296"));
        final Country chad = new Country("Chad", new BigDecimal("12185000"));
        europe.addCountry(poland);
        europe.addCountry(italy);
        europe.addCountry(spain);
        asia.addCountry(japan);
        asia.addCountry(china);
        asia.addCountry(india);
        africa.addCountry(egypt);
        africa.addCountry(kenya);
        africa.addCountry(chad);
        //When
        final BigDecimal totalPeopleQuantity = world.getPeopleQuantity();
        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("3147591016");
        assertEquals(expectedPeopleQuantity, totalPeopleQuantity);
        assertEquals(3, world.getContinentList().size());
        assertEquals(3, europe.getCountryList().size());
        assertEquals(3, asia.getCountryList().size());
        assertEquals(3, africa.getCountryList().size());
    }
}
