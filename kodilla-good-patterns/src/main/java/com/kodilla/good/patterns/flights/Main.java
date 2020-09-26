package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.domain.Flight;
import com.kodilla.good.patterns.flights.resources.AirportResource;
import com.kodilla.good.patterns.flights.services.AirportService;
import com.kodilla.good.patterns.flights.services.FlightSearchService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AirportService airportService = new AirportService(new AirportResource());
        FlightSearchService flightSearchService = new FlightSearchService(airportService);
        List<Flight> foundFlights = flightSearchService.findFlight("bzg", "waw");

    }
}
