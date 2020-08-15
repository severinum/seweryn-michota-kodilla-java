package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WorldTestSuite {

    @Test
    void testGetPeopleQuantity(){
        // given
        Country china = new Country(new BigDecimal("1394015977"));
        Country india = new Country(new BigDecimal("1326093247"));
        Country usa = new Country(new BigDecimal("329977505"));
        Country canada = new Country(new BigDecimal("37590000"));
        Country nigeria = new Country(new BigDecimal("214028302"));
        Country kenya = new Country(new BigDecimal("51390000"));
        Country brazil = new Country(new BigDecimal("211715973"));
        Country colombia = new Country(new BigDecimal("49650000"));
        Country germany = new Country(new BigDecimal("83200000"));
        Country poland =  new Country(new BigDecimal("37970000"));

        Continent asia = new Continent();
        asia.addCountry(china);
        asia.addCountry(india);

        Continent nthAmerica = new Continent();
        nthAmerica.addCountry(usa);
        nthAmerica.addCountry(canada);

        Continent sthAmerica = new Continent();
        sthAmerica.addCountry(brazil);
        sthAmerica.addCountry(colombia);

        Continent europe = new Continent();
        europe.addCountry(germany);
        europe.addCountry(poland);

        Continent africa = new Continent();
        africa.addCountry(kenya);
        africa.addCountry(nigeria);

        World world = new World();
        world.addContinent(asia);
        world.addContinent(nthAmerica);
        world.addContinent(sthAmerica);
        world.addContinent(europe);
        world.addContinent(africa);

        BigDecimal totalPeopleInTheWorld = world.getPeopleQuantity();
        BigDecimal expctedNumOfPeople = new BigDecimal("3735631004");
        int totalNumerOfCountries = world.numberOfCountries();

        assertEquals(expctedNumOfPeople, totalPeopleInTheWorld);
        assertEquals(10, totalNumerOfCountries ); // helper test to check if all countries has been added
    }

}