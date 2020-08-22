package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightFinderSimulator {

    private final Map<String, Boolean> availableAirports = new HashMap<>();
    private final List<Flight> flights = new ArrayList<>();

    public static void main(String[] args) {
        FlightFinderSimulator simulator = new FlightFinderSimulator();
        simulator.addFlight(new Flight("London Stansted", "Warsaw"));
        simulator.addFlight(new Flight("London Stansted", "Krakov"));

        try {
            boolean hasWarsaw = simulator.flightFinder(new Flight("London Stansted", "Warsaw"));
            boolean hasKrakov = simulator.flightFinder(new Flight("London Stansted", "Krakov"));
            boolean hasBydgoszcz = simulator.flightFinder(new Flight("London Stansted", "Bydgoszcz"));
            boolean haReykjavik = simulator.flightFinder(new Flight("London Stansted", "Reykjavik")); // ominięte z powodu powyższego exception
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addFlight(Flight flight) {
        flights.add(flight);
        availableAirports.put(flight.getArrivalAirport(), true);
    }

    public boolean flightFinder(Flight flight) throws RouteNotFoundException {
        Map<String , Boolean> availableFlight = new HashMap<>(availableAirports);
        boolean found = availableFlight.entrySet().stream()
                .anyMatch(entry -> entry.getKey().equals(flight.getArrivalAirport()));
        if(found) {
            return true;
        } else {
            throw new RouteNotFoundException("Route to " + flight.getArrivalAirport() + " not found" );
        }
    }
}