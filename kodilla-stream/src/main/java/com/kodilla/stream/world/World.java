package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {
    private final Set<Continent> continents = new HashSet<>();

    public void addContinent(Continent continent){
        continents.add(continent);
    }

    public BigDecimal getPeopleQuantity(){
       return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (pplSum, countryPopulation) -> pplSum = pplSum.add(countryPopulation));
    }

    public int numberOfCountries(){
        return continents.stream()
                .map(continent -> continent.getCountries().size())
                .reduce(0, (sum, curr) -> sum += curr);
    }
}
