package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public final class ExtraFoodShop implements SupplierInterface {

    private final String name;
    private final String email;
    private final Map<Product, Integer> products = new HashMap<>();

    public ExtraFoodShop(final String name,final String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    @Override
    public OrderDTO process(OrderRequest orderRequest) {
        return null;
    }
}
