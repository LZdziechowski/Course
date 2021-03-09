package com.kodilla.good.patterns.food2door.supplier;

import com.kodilla.good.patterns.food2door.order.Order;
import com.kodilla.good.patterns.food2door.order.OrderItem;
import com.kodilla.good.patterns.food2door.order.OrderSummaryItem;
import com.kodilla.good.patterns.food2door.product.Product;
import com.kodilla.good.patterns.food2door.product.ProductDetails;

import java.math.BigDecimal;
import java.util.Optional;

public interface Supplier {

    OrderSummaryItem process(OrderItem orderItem);

    void addProduct(Product product, int amount, BigDecimal price);

    int reserveProduct(Product product, int amount);

    Optional<BigDecimal> getPrice(Product product);
}
