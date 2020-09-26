package com.kodilla.good.patterns.flights.services;

import com.kodilla.good.patterns.flights.domain.Airport;
import com.kodilla.good.patterns.flights.domain.Flight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightSearchService {

    private AirportService airportService;

    private Map<String, Airport> airports = new HashMap<>();

    public FlightSearchService(AirportService airportService) {
        this.airportService = airportService;
        airports = airportService.getAllAirports();
    }

    public List<Flight> findFlight(String from , String to){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ SEARCHING FOR A FLIGHT ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        from = from.toUpperCase();
        to = to.toUpperCase();

        Airport airportFrom = airports.get(from);
        Airport airportTo = airports.get(to);

        System.out.println("FROM: " + airportFrom.getLocation() + " (" + airportFrom.getId() + ")");
        System.out.println("TO: " + airportTo.getLocation() + " (" + airportTo.getId() + ")");

        return null;
    }

}
