package com.kodilla.good.patterns.food2door.order;

import com.kodilla.good.patterns.food2door.product.Product;

public class OrderItem {

    private final Product product;
    private final int amount;

    public OrderItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

}
