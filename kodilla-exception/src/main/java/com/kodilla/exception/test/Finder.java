package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Finder {

    final private Map<String, Boolean> airports = new HashMap<>();

    public Finder(int airportNumber) {
        generateAirports(airportNumber);
    }

    public void generateAirports(int airportNumber) {
        boolean value = true;
        for (int i = 1; i <= airportNumber; i++) {
            value = !value;
            airports.put("name " + i, value);
        }
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {

        final Map<String, Boolean> map = new HashMap<>(airports);
        final boolean value;
        final String arrivalAirport = flight.getArrivalAirport();

        if (map.containsKey(arrivalAirport)) {
            value = map.get(arrivalAirport);
        } else {
            throw new RouteNotFoundException("Airport not exist!");
        }

        if (value) {
            System.out.println("You can fly.");
        } else {
            System.out.println("You can not fly.");
        }
    }

    public boolean airportFromToWithChange(Flight flight) {
        final Map<String, Boolean> map = new HashMap<>(airports);
        final String arrivalAirport = flight.getArrivalAirport();

        if (map.containsKey(arrivalAirport) && map.get(arrivalAirport) == true) {
            return true;
        } else {
            map.entrySet().stream()
                    .filter(airport -> airport.getValue() == true)
                    .forEach();



    }
}
