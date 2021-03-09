package com.kodilla.good.patterns.food2door.supplier;

import com.kodilla.good.patterns.food2door.order.OrderItem;
import com.kodilla.good.patterns.food2door.order.OrderSummaryItem;

import java.math.BigDecimal;

public class HealthyShop extends AbstractSupplier {

    private final String name = this.getClass().getName();

    @Override
    public OrderSummaryItem process(OrderItem orderItem) {
        final int reserved = reserveProduct(orderItem.getProduct(), orderItem.getAmount());
        if( reserved == 0) {
            return null;
        }
        return new OrderSummaryItem(
                name,
                orderItem.getProduct(),
                reserved,
                getPrice(orderItem.getProduct()).get().multiply(new BigDecimal(reserved))
        );
    }
}
