package com.kodilla.good.patterns.food2door;

public class OrderProduct implements OrderService {
    @Override
    public boolean order(Supplier supplier, Product product, int quantity) {
        if (supplier.getProductNames().contains(product)) {
            final int index = supplier.getProductNames().indexOf(product);
            final Product orderedProduct = supplier.getProductNames().get(index);

            if (orderedProduct.getQuantity() < quantity) {
                System.out.println("Not enough products!");
                return false;
            } else {
                orderedProduct.setQuantity(quantity);
                return true;
            }
        }
        System.out.println("No product!");
        return false;
    }
}
