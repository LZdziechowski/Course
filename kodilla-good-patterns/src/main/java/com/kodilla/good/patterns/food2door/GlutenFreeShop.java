package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public final class GlutenFreeShop implements SupplierInterface {

    private final String name;
    private final String email;
    private final Map<Product, Integer> products = new HashMap<>();

    public GlutenFreeShop(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public Map<Product, Integer> getProducts() {
        return null;
    }

    @Override
    public OrderDTO process(OrderRequest orderRequest) {
        return null;
    }
}
