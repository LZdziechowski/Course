package com.kodilla.good.patterns.food2door;

public final class OrderRequest {

    private final Supplier supplier;
    private final Product product;
    private  final int quantity;

    public OrderRequest(final Supplier supplier,final Product product, final int quantity) {
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
    }

    public Supplier getUser() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
