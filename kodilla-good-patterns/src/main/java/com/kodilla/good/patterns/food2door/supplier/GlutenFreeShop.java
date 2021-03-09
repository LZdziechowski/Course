package com.kodilla.good.patterns.food2door.supplier;

import com.kodilla.good.patterns.food2door.order.OrderItem;
import com.kodilla.good.patterns.food2door.order.OrderSummaryItem;

import java.math.BigDecimal;

public class GlutenFreeShop extends AbstractSupplier{

    private final String name = this.getClass().getSimpleName();

    @Override
    public OrderSummaryItem process(OrderItem orderItem) {
        final int reserved = reserveProduct(orderItem.getProduct(), orderItem.getAmount());
        if( reserved == 0) {
            return null;
        }
        final BigDecimal finalPrice = getPrice(orderItem.getProduct())
                .map(p -> p.multiply(new BigDecimal(reserved)))
                .orElse(BigDecimal.ZERO);
        return new OrderSummaryItem(
                name,
                orderItem.getProduct(),
                reserved,
                finalPrice
        );
    }
}
