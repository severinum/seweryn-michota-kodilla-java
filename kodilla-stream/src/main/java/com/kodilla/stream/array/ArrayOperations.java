package com.kodilla.stream.array;

import org.w3c.dom.ls.LSOutput;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers){
         if (numbers.length == 0)
             return 0;
         IntStream.range(0, numbers.length)
                .forEach( n -> System.out.println(numbers[n]));

         Double avg = IntStream.range(0, numbers.length)
                .map( n -> numbers[n])
                .average()
                 .orElse(0.0);
         return avg;
    }
}
