package com.kodilla.good.patterns.flights.resources;

import com.kodilla.good.patterns.flights.domain.Airport;
import com.kodilla.good.patterns.flights.domain.Flight;

import java.util.HashMap;
import java.util.Map;

public class AirportResource {

    private HashMap<String, Airport> airports = new HashMap<>();

    public AirportResource() {

        Airport waw = new Airport("WAW", "Warszawa");
        Airport wmi = new Airport("WMI", "Modlin");
        Airport wro = new Airport("WRO", "Wrocław");
        Airport poz = new Airport("POZ", "Poznań");
        Airport krk = new Airport("KRK", "Kraków");
        Airport ktw = new Airport("KTW", "Katowice");
        Airport lcj = new Airport("LCJ", "Lodz");
        Airport gdn = new Airport("GDN", "Gdańsk");
        Airport bzg = new Airport("BZG","Bydgoszcz");
        Airport rze = new Airport("RZE","Rzeszów");
        Airport szz = new Airport("SZZ", "Szczecin");
        Airport ieg = new Airport("IEG","Zielona Góra");

        airports.put("WAW", waw);
        airports.put("WMI", wmi);
        airports.put("WRO", wro);
        airports.put("POZ", poz);
        airports.put("KRK", krk);
        airports.put("KTW", ktw);
        airports.put("LCJ", lcj);
        airports.put("GDN", gdn);
        airports.put("BZG", bzg);
        airports.put("RZE", rze);
        airports.put("SZZ", szz);
        airports.put("IEG", ieg);

        addFlight(new Flight(waw, wro));
        addFlight(new Flight(waw, bzg));
        addFlight(new Flight(bzg, waw));
        addFlight(new Flight(waw, gdn));
        addFlight(new Flight(wro, lcj));
        addFlight(new Flight(gdn, bzg));
        addFlight(new Flight(bzg, gdn));
        addFlight(new Flight(waw, lcj));
        addFlight(new Flight(lcj, wro));

        displayAllAirportsData();

    }

    public void addFlight(Flight flight){
        Airport from = flight.getFrom();
        Airport to = flight.getTo();

        airports.get(from.getId()).addOutgoingFlightLocation(to);
        airports.get(to.getId()).addIncomingFlightLocation(from);
    }

    public Map<String, Airport> getAll(){
        return airports;
    }

    private Airport getById(String id){
        return airports.get(id);
    }

    private void displayAllAirportsData(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ AIRPORTS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(Map.Entry<String, Airport> entry : airports.entrySet()){
            System.out.println(entry.getValue().toString());
            System.out.println("\t" + entry.getValue().getLocation() + " outgoing flights : " + entry.getValue().getOutgoingFlightsLocations());
            System.out.println("\t" + entry.getValue().getLocation() + " incoming flights : " + entry.getValue().getIncomingFlightsLocations());
        }
    }
}
