package com.kodilla.good.patterns.food2door;

public class ProductOrderRepository implements OrderRepository {
    @Override
    public boolean createOrder(Supplier supplier, Product product, int quantity) {

        System.out.println("Order saved.");
        return true;
    }
}
