package com.kodilla.good.patterns.food2door.order;

import com.kodilla.good.patterns.food2door.product.Product;
import com.kodilla.good.patterns.food2door.supplier.Shops;
import com.kodilla.good.patterns.food2door.supplier.Supplier;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderProcessor {

    private final Set<Supplier> availableSuppliers;

    public OrderProcessor(Shops shops) {
        this.availableSuppliers = shops.getShops();
    }

    public OrderSummary order(Order order) {
        final OrderSummary summary = new OrderSummary();
        for (OrderItem orderItem : order.getOrderItems()) {
            int requiredAmount = orderItem.getAmount();
            for (Supplier supplier : orderSupplierFromTheCheapest(orderItem.getProduct())) {
                if (requiredAmount > 0) {
                    final OrderSummaryItem orderSummaryItem = supplier.process(new OrderItem(orderItem.getProduct(), requiredAmount));
                    requiredAmount -= orderSummaryItem.getRealizedAmount();
                    summary.addItem(orderSummaryItem);
                }
            }
        }
        return summary;
    }

    private Set<Supplier> orderSupplierFromTheCheapest(Product product) {
        return availableSuppliers.stream()
                .filter(supplier -> supplier.getPrice(product).isPresent())
                .sorted(Comparator.comparing(s -> s.getPrice(product).get()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
