package com.kodilla.patterns.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTestSuite {

    @Test
    void testPizzaNew(){
        // given
        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredient("Onion")
                .bottom("Thin")
                .sauce("Spicy")
                .ingredient("Ham")
                .ingredient("Mushrooms")
                .build();
        System.out.println(pizza);
        // when
        int howManyIngredients = pizza.getIngredients().size();
        // then
        assertEquals(3, howManyIngredients);
    }

}