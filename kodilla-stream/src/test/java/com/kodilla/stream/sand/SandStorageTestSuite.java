package com.kodilla.stream.sand;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SandStorageTestSuite {

    @Test
    void testGetSandBeansQty(){
        // given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());
        // when
        BigDecimal totalSand = BigDecimal.ZERO;
        for(SandStorage continent: continents){
            totalSand = totalSand.add(continent.getSandBeansQuantity());
        }
        // then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        assertEquals(expectedSand, totalSand);
    }

    @Test
    void testGetSandBeansQuantityWithReduce(){
        // given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());
        // when
        BigDecimal totalSand = continents.stream()
                .map(SandStorage::getSandBeansQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        // then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        assertEquals(expectedSand, totalSand);
    }


    @Test
    void myTestJustToStudy(){
        // given
        List<Integer> liczby = new ArrayList<>();
        liczby.add(10);
        liczby.add(20);
        liczby.add(8);
        // when
        Integer sumaLiczb = liczby.stream()
                .reduce(0, (sum, current) -> sum += current);
        // then
        assertEquals(38, sumaLiczb);
    }
}