package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        System.out.println("Test BigmacBuilder() method");
        //Given
        final Bigmac bigmac = new Bigmac.BigmacBuilder(true, 3)
                .sauce(Sauce.THOUSAND_ISLANDS)
                .ingredient(Ingredient.CHEESE)
                .ingredient(Ingredient.ONION)
                .build();
        System.out.println(bigmac);
        //When
        final int howManyIngredient = bigmac.getIngredients().size();
        final int howManyBurgers = bigmac.getNumberOfBurgers();
        //Then
        assertEquals(2, howManyIngredient);
        assertEquals(3, howManyBurgers);
        assertTrue(bigmac.isBunSesame());
    }
}
