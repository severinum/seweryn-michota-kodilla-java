package com.kodilla.good.patterns.flights.dto;

import com.kodilla.good.patterns.flights.domain.Flight;
import java.util.List;

public class FlightSearchDto {

    private Flight directFlight;
    private List<Flight> jointFlights;

    public FlightSearchDto(Flight directFlight, List<Flight> jointFlights) {
        this.directFlight = directFlight;
        this.jointFlights = jointFlights;
    }

    public Flight getDirectFlight() {
        return directFlight;
    }

    public List<Flight> getJointFlights() {
        return jointFlights;
    }
}
