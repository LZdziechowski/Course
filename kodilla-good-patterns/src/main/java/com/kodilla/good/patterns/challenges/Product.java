package com.kodilla.good.patterns.challenges;

public class Product {

    private final String name;
    private final double prize;

    public Product(final String name,final double prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public double getPrize() {
        return prize;
    }
}
