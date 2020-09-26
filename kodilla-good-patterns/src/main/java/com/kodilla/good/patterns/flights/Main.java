package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.domain.Flight;
import com.kodilla.good.patterns.flights.repository.FlightsRepository;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        FlightsRepository flightsRepository = new FlightsRepository();

        Set<Flight> allFlights = flightsRepository.getAllFlights();
        allFlights.stream().forEach(System.out::println);

    }
}
