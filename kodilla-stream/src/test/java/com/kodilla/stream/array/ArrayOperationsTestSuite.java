package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        // given
        int[] numbers = {3, 5, 8, 12, 6, 10, 45};
        // when
        double avg = ArrayOperations.getAverage(numbers);
        // then
        assertEquals(12.71, avg, 0.01);
    }

}