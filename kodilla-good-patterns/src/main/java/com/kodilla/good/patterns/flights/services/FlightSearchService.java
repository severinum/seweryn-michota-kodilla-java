package com.kodilla.good.patterns.flights.services;

import com.kodilla.good.patterns.flights.domain.Airport;
import com.kodilla.good.patterns.flights.domain.Flight;
import com.kodilla.good.patterns.flights.dto.FlightSearchDto;

import java.util.ArrayList;
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

    public FlightSearchDto findFlights(String from , String to){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ SEARCHING FOR A FLIGHT ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        from = from.toUpperCase();
        to = to.toUpperCase();

        Airport airportFrom = airports.get(from);
        Airport airportTo = airports.get(to);

        System.out.print("FROM: " + airportFrom.getLocation() + " (" + airportFrom.getId() + ")");
        System.out.print("\tTO: " + airportTo.getLocation() + " (" + airportTo.getId() + ")\n");

        List<Flight> jointFlights = new ArrayList<>();
        Flight directFlight = null;
        if(airportFrom.getOutgoingFlightsLocations().contains(airportTo)){
            directFlight = new Flight(airportFrom, airportTo);
        }
        for(Airport airport : airportFrom.getOutgoingFlightsLocations()){
            if(airport.getOutgoingFlightsLocations().contains(airportTo)){
                jointFlights.add(new Flight(airportFrom, airport));
                jointFlights.add(new Flight(airport, airportTo));
            }
        }

        return new FlightSearchDto(directFlight, jointFlights);
    }

}
