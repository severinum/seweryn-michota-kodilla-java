package com.kodilla.exception.moje_testy.exceptions;

import java.util.HashMap;
import java.util.Map;

public class MapExceptionTest {

    private final Map<City, Integer> cities = new HashMap<>();

    public static void main(String[] args) {

        MapExceptionTest mapExceptionTest = new MapExceptionTest();

        Country poland = new Country("Poland");
        Country germany = new Country("Germany");

        City warsaw = new City("Warsaw" , poland );
        City bydgoszcz  = new City("Bydgoszcz", poland);
        City gdansk = new City("Gdans", poland);

        City berlin = new City("Berlin", germany);
        City munich = new City("Munich", germany);
        City hamburg = new City("Hamburg", germany);

        mapExceptionTest.cities.put(warsaw, 1700000);
        mapExceptionTest.cities.put(bydgoszcz, 354000);
        mapExceptionTest.cities.put(warsaw, 582000);

        mapExceptionTest.cities.put(berlin, 3800000);
        mapExceptionTest.cities.put(munich, 1400000);
        mapExceptionTest.cities.put(hamburg, 1900000);

        System.out.println("Cities in the list : ");
        mapExceptionTest.cities.forEach( (city, population) -> {
            System.out.println(city.getName() + ": \tpopulation: " + population);
        } );

        try {
            String cityNameThatExists = "Bydgoszcz";
            Integer population = mapExceptionTest.findCityPopulation(cityNameThatExists);
            System.out.println("Population of " + cityNameThatExists + " : " + population);

            String cityNameThatNotExists = "New York";
            population = mapExceptionTest.findCityPopulation(cityNameThatNotExists);
            System.out.println("Population of " + cityNameThatNotExists + " : " + population);

        } catch (CityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }


    public Integer findCityPopulation(String cityName) throws CityNotFoundException {
        for(Map.Entry<City, Integer> city: this.cities.entrySet()){
            if(city.getKey().getName().toLowerCase().equals(cityName.toLowerCase())){
                return city.getValue();
            }
        }
        throw new CityNotFoundException("City " + cityName + " not found");
    }

}
