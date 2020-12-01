package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public final class HealthyShop implements SupplierInterface {

    private final String name;
    private final String email;
    private final Map<Product, Integer> products = new HashMap<>();

    public HealthyShop(final String name,final String email) {
        this.name = name;
        this.email = email;
    }
    @Override
    public OrderDTO process(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Map<Product, Integer> getProducts() {
        return products;
    }
}
