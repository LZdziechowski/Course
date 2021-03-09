package com.kodilla.good.patterns.food2door.supplier;

import java.util.HashSet;
import java.util.Set;

public class Shops {

    private Set<Supplier> shops = new HashSet<>();

    public void addShop(Supplier supplier) {
        shops.add(supplier);
    }

    public Set<Supplier> getShops() {
        return shops;
    }
}
