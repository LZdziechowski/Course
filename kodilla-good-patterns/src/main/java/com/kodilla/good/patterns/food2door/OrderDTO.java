package com.kodilla.good.patterns.food2door;

public final class OrderDTO {

    private final SupplierInterface supplier;
    private final boolean isOrdered;

    public OrderDTO(final SupplierInterface supplier, final boolean isOrdered) {
        this.supplier = supplier;
        this.isOrdered = isOrdered;
    }

    public SupplierInterface getSupplier() {
        return supplier;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
