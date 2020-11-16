package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final String name;
    private final List<Country> countryList = new ArrayList<>();

    public Continent(String name) {
        this.name = name;
    }

    public void addCountry(Country country) {
        countryList.add(country);
    }

    public void removeCountry(Country country) {
        countryList.remove(country);
    }

    public String getName() {
        return name;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
