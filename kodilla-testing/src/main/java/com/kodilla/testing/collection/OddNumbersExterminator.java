package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();

        if (numbers.size() == 0){
            return list;
        }

        for (Integer number : numbers){
            if(number % 2 == 0)
                list.add(number);
        }

        return list;
    }

}
