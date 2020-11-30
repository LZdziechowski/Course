package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.challenges.User;

public final class OrderDTO {

    private final Supplier supplier;
    private final boolean isOrdered;

    public OrderDTO(final Supplier supplier,final boolean isOrdered) {
        this.supplier = supplier;
        this.isOrdered = isOrdered;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
