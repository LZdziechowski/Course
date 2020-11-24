package com.kodilla.good.patterns.aviation.company;

import java.util.ArrayList;
import java.util.List;

public class FlightSearch {

    private final String flightFrom;
    private final String flightTo;
    private final String flightThrough;
    private final int choice;


    public FlightSearch(final String flightFrom, final String flightTo, final String flightThrough, final int choice) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.flightThrough = flightThrough;
        this.choice = choice;
    }

    public void search () {
        switch (choice) {
            case 1:
                findFlightFrom();
                break;
            default:
                System.out.println();
        }

    }

    public void findFlightFrom() {
        if (flightFrom != null) {
            if (FlightsList.getFlights().contains(flightFrom)) {
                List<Flight> list = new ArrayList<>(FlightsList.getFlights());
                list.stream()
                        .filter(flight -> flight.getDepartureFrom().equals(flightFrom))
                        .forEach(flight -> System.out.println(toString()));
            }
        }
    }
}
