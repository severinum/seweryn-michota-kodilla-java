package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Odd Numbers Exterminator Test Suite")
class OddNumbersExterminatorTestSuite {

    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("Shuld return 0 as list size if empty list is passed as an argument")
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> passedlist = new ArrayList<>();
        int listSize = oddNumbersExterminator.exterminate(passedlist).size();
        int expectedSize = 0;
        System.out.println("List size : " + listSize + "\nExpected size: " + expectedSize);
        assertEquals(expectedSize, listSize);
    }

    @DisplayName("Shuld return 6 as list size if not empty list is passed as an argument")
    @Test
    public void testOddNumbersExterminatorNormalList(){
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> passedlist = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
        int listSize = oddNumbersExterminator.exterminate(passedlist).size();
        int expectedSize = 6;
        System.out.println("List size : " + listSize + "\nExpected size: " + expectedSize);

        assertEquals(expectedSize, listSize);
    }

}