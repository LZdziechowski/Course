package com.kodilla.good.patterns.food2door.order;

import java.util.HashSet;
import java.util.Set;

public class Order {

    private Set<OrderItem> orderItems = new HashSet<>();

    public void addItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public boolean removeItem(OrderItem orderItem) {
        if (orderItems.contains(orderItem)) {
            orderItems.remove(orderItem);
            return true;
        }
        return false;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }
}
