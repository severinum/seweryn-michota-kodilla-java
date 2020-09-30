package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;
    private double a = 5;
    private double b = 2;
    private double c = 0;

    @Test
    public void testAddition(){
        // given
        // when
        double result = calculator.add(a, b);
        // then
        assertEquals(7, result);
    }

    @Test
    public void testSubtraction(){
        // given
        // when
        double result = calculator.sub(a, b);
        // then
        assertEquals(3, result);
    }

    @Test
    public void testMultiplication(){
        // given
        // when
        double result = calculator.mul(a, b);
        // then
        assertEquals(10, result);
    }

    @Test
    public void testDivision(){
        // given
        // when
        double result = calculator.div(a, b);
        // then
        assertEquals(2.5, result, 0.001);

        result = calculator.div(c, a);
        assertEquals(0, result);

        /* dividing by zero : returns ArithmeticException */
        assertThrows(ArithmeticException.class, ()->{ calculator.div(a,c); });
    }

}