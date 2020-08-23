package com.kodilla.stream.moje_testy;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class IntStrreamAverage {

    public static void main(String[] args) {
        double average  = IntStream.of(10,20,30).average().orElse(0);
        System.out.println(average);

        int[] liczby = {10,20,30};

        double isDbl = IntStream.of(liczby).average().orElse(0);
        System.out.println(isDbl);

    }

}
