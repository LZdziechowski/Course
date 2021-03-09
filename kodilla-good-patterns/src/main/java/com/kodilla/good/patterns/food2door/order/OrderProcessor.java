package com.kodilla.good.patterns.food2door.order;

import com.kodilla.good.patterns.food2door.supplier.Shops;
import com.kodilla.good.patterns.food2door.supplier.Supplier;

import java.util.Set;

public class OrderProcessor {

    private final Set<Supplier> availableSuppliers;

    public OrderProcessor(Shops shops) {
        this.availableSuppliers = shops.getShops();
    }

    public OrderSummary order(Order order) {
        final OrderSummary summary = new OrderSummary();
        for (OrderItem orderItem : order.getOrderItems()) {
            for (Supplier supplier : availableSuppliers) {
                summary.addItem(supplier.process(orderItem));
            }
        }
        return summary;
    }
}
