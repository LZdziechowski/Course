package com.kodilla.good.patterns.food2door.order;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderSummary {

    private Set<OrderSummaryItem> orderSummaryItems = new LinkedHashSet<>();

    public void addItem(OrderSummaryItem orderSummaryItem) {
        orderSummaryItems.add(orderSummaryItem);
    }

    public boolean removeItem(OrderSummaryItem orderSummaryItem) {
        if (orderSummaryItems.contains(orderSummaryItem)) {
            orderSummaryItems.remove(orderSummaryItem);
            return true;
        }
        return false;
    }

    public Set<OrderSummaryItem> getOrderSummaryItems() {
        return orderSummaryItems;
    }

    @Override
    public String toString() {
        return "OrderSummary{" +
                "orderSummaryItems=" + orderSummaryItems +
                '}';
    }
}
