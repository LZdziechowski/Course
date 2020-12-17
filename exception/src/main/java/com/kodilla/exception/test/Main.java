package com.kodilla.exception.test;

public class Main {

    public static void main(String[] args) {

        Flight flight = new Flight("name 34", "name 43");
        Finder finder = new Finder(100);

        try {
            finder.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("Route not found.");
        }
    }
}
