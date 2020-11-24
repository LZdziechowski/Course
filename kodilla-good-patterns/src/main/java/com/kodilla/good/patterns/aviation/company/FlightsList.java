package com.kodilla.good.patterns.aviation.company;

import java.util.ArrayList;
import java.util.List;

public class FlightsList {

    private static final List<Flight> flights = new ArrayList<>();

    public static void addFlight(Flight flight) {
        flights.add(flight);
    }

    public static boolean removeFlight(Flight flight) {
        if (flights.contains(flight)) {
            flights.remove(flight);
            return true;
        }
        return false;
    }

    public static List<Flight> getFlights() {
        return flights;
    }
}

