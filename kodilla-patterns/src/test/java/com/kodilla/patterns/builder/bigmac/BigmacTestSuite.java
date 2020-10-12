package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigmacTestSuite {

    @Test
    void testBigmacBuilder(){
        // given
        Bigmac bigmac = new Bigmac.BurgerBuilder()
                .bun("sesame bun")
                .burgers(2)
                .sauce("spicy mayo")
                .ingredient("pickled onions")
                .ingredient("gherkins")
                .ingredient("cheese")
                .build();
        // when
        int ingredientsNumber = bigmac.getIngredients().size();
        String sauceName = bigmac.getSauce();
        // then
        assertEquals(3, ingredientsNumber);
        assertEquals("spicy mayo", sauceName);
    }

}