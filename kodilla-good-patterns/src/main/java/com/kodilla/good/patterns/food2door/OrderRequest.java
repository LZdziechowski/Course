package com.kodilla.good.patterns.food2door;

public final class OrderRequest {

    private final User user;
    private final SupplierInterface supplier;
    private final Product product;
    private  final int quantity;

    public OrderRequest(final User user, final SupplierInterface supplier, final Product product, final int quantity) {
        this.user = user;
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
    }

    public SupplierInterface getUser() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
