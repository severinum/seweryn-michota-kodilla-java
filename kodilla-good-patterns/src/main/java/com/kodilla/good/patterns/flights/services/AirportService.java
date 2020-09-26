package com.kodilla.good.patterns.flights.services;

import com.kodilla.good.patterns.flights.domain.Airport;
import com.kodilla.good.patterns.flights.resources.AirportResource;

import java.util.Map;

public class AirportService {

    private AirportResource airportResource;

    public AirportService(AirportResource airportResource) {
        this.airportResource = airportResource;
    }

    public Map<String, Airport> getAllAirports(){
        return airportResource.getAll();
    }
}
