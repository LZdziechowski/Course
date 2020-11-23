package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class Supplier {

    private final String name;
    private final List<Product> productNames = new ArrayList<>();

    public Supplier(final String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        productNames.add(product);
    }

    public boolean removeProduct(Product product) {
        if (productNames.contains(product)) {
            productNames.remove(product);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProductNames() {
        return productNames;
    }
}
