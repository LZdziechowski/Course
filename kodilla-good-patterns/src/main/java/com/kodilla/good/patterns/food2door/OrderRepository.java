package com.kodilla.good.patterns.food2door;

public interface OrderRepository {
    boolean createOrder(Supplier supplier, Product product, int quantity);
}
