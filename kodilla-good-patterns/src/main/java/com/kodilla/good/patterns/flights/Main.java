package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.dto.FlightSearchDto;
import com.kodilla.good.patterns.flights.resources.AirportResource;
import com.kodilla.good.patterns.flights.services.AirportService;
import com.kodilla.good.patterns.flights.services.FlightSearchService;

public class Main {

    public static void main(String[] args) {
        AirportService airportService = new AirportService(new AirportResource());
        FlightSearchService flightSearchService = new FlightSearchService(airportService);

        FlightSearchDto foundFlights1Dto = flightSearchService.findFlights("bzg", "waw");
        System.out.println("Found Direct Flight: " + foundFlights1Dto.getDirectFlight());
        System.out.println("Found Joint Flights: " + foundFlights1Dto.getJointFlights());

        FlightSearchDto foundFlights2Dto = flightSearchService.findFlights("GDN", "WAW");
        System.out.println("Found Direct Flight: " + foundFlights2Dto.getDirectFlight());
        System.out.println("Found Joint Flights: " + foundFlights2Dto.getJointFlights());

        FlightSearchDto foundFlights3Dto = flightSearchService.findFlights("BZG", "WRO");
        System.out.println("Found Direct Flight: " + foundFlights3Dto.getDirectFlight());
        System.out.println("Found Joint Flights: " + foundFlights3Dto.getJointFlights());

        FlightSearchDto foundFlights4Dto = flightSearchService.findFlights("WAW", "WRO");
        System.out.println("Found Direct Flight: " + foundFlights4Dto.getDirectFlight());
        System.out.println("Found Joint Flights: " + foundFlights4Dto.getJointFlights());
    }
}
