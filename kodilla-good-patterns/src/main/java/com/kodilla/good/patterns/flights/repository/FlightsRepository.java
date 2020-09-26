package com.kodilla.good.patterns.flights.repository;

import com.kodilla.good.patterns.flights.domain.Flight;

import java.util.*;

public class FlightsRepository {

    private Set<Flight> flights = new HashSet<>();

    public FlightsRepository() {
        flights.add(new Flight("WARSZAWA", "GDANSK"));
        flights.add(new Flight("GDANSK", "WARSZAWA"));
        flights.add(new Flight("GDANSK", "BYDGOSZCZ"));
        flights.add(new Flight("GDANSK", "WROCLAW"));
        flights.add(new Flight("WROCLAW", "WARSZAWA"));
        flights.add(new Flight("WROCLAW", "KRAKOW"));
        flights.add(new Flight("KRAKOW", "GDANSK"));
        flights.add(new Flight("GDANSK", "KRAKOW"));
        flights.add(new Flight("WARSZAWA", "POZNAN"));
        flights.add(new Flight("POZNAN", "WARSZAWA"));
    }

    public Set<Flight> getAllFlights(){
        return flights;
    }

    public Optional<Flight> getAllFlightsFrom(String from){
        return flights.stream()
                .filter(flight -> flight.getFrom()
                        .equals(from)).findAny();
    }

    public Optional<Flight> getAllFlightsTo(String to){
        return flights.stream()
                .filter(flight -> flight.getTo()
                        .equals(to)).findAny();
    }
}
