package com.kodilla.good.patterns.aviation.company;


public class Main {

    public static void main(String[] args) {

        FlightsGenerator flightsGenerator = new FlightsGenerator();
        FlightValidator flightValidator = new FlightValidator(flightsGenerator.flightsGenerator(5));
        System.out.println(flightValidator.getFlights());
        System.out.println(flightValidator.validateFlyFromTo("Airport3", "Airport5"));

    }
}
