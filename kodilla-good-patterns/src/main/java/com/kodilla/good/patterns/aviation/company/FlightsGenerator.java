package com.kodilla.good.patterns.aviation.company;

import java.util.*;

public class FlightsGenerator {

    Random random = new Random();

    public Map<String, Set<String>> flightsGenerator(int numberOfAirports) {
        Map<String, Set<String>> flights = new LinkedHashMap<>();
        int counter = 1;
        while (counter <= numberOfAirports) {
            Set<String> listTo = new HashSet<>();
            String from = "Airport" + counter;
            int randomNumberToFly = random.nextInt(numberOfAirports) + 1;
                for (int i = 1; i <= randomNumberToFly; i++){
                    int airportNumber = random.nextInt(numberOfAirports) + 1;
                    listTo.add("Airport" + airportNumber);
                }
            flights.put(from, listTo);
                counter ++;
        }
        return flights;
    }
}

