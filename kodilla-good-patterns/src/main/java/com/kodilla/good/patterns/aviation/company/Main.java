package com.kodilla.good.patterns.aviation.company;


public class Main {

    public static void main(String[] args) {

        FlightsList.addFlight(new Flight("Warsaw", "London"));
        FlightsList.addFlight(new Flight("Warsaw", "Paris"));
        FlightsList.addFlight(new Flight("Warsaw", "Dubai"));
        FlightsList.addFlight(new Flight("Dubai", "Warsaw"));
        FlightsList.addFlight(new Flight("Cracow", "Paris"));
        FlightsList.addFlight(new Flight("London", "Cracow"));

        final FlightSearch flightSearch = new FlightSearch("Warsaw", null, null, 1);

        flightSearch.search();
    }
}
