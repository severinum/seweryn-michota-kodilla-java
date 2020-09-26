package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.domain.Flight;
import com.kodilla.good.patterns.flights.repository.FlightsRepository;

import java.util.Optional;
import java.util.Set;

public class FlightService {

    private FlightsRepository flightsRepository;

    public FlightService(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    public Optional<Flight> searchFlightsFrom(String from){
        return flightsRepository.getAllFlightsFrom(from);
    }

    public Optional<Flight> searchFlightsTo(String to){
        return flightsRepository.getAllFlightsTo(to);
    }

    public Set<Flight> searchFlight(String from , String to){
        return null;
    }

}
