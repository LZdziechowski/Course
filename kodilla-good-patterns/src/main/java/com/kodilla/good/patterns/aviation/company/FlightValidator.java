package com.kodilla.good.patterns.aviation.company;

import java.util.*;

public class FlightValidator {

    private Map<String, Set<String>> flights;
    private Set<String> checkedAirports = new LinkedHashSet<>();

    public FlightValidator(Map<String, Set<String>> flights) {
        this.flights = new LinkedHashMap<>(flights);
    }

    public boolean validateFlyFromTo(String from, String to) {
        checkedAirports.add(from);
        System.out.println("checking: " + from + "->" + to);
        if (flights.get(from).contains(to)) {
            checkedAirports.clear();
            return true;
        } else if (!flights.get(from).isEmpty()){
            Set<String> airports = flights.get(from);
            for (String airport : airports) {
                if (!checkedAirports.contains(airport)) {
                    if (validateFlyFromTo(airport, to)) {
                        return true;
                    }
                }
            }
        }
        checkedAirports.clear();
        return false;
    }

    public Map<String, Set<String>> getFlights() {
        return flights;
    }
}
