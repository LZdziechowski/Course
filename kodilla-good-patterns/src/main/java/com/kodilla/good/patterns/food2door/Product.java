package com.kodilla.good.patterns.food2door;

public class Product {

    private final String name;
    private int quantity;

    public Product(final String name, final int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int orderedQuantity) {
        quantity -= orderedQuantity;
    }
}
