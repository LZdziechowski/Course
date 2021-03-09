package com.kodilla.good.patterns.food2door.order;

import com.kodilla.good.patterns.food2door.product.Product;
import com.kodilla.good.patterns.food2door.supplier.Supplier;

import java.math.BigDecimal;

public class OrderSummaryItem {

    private final String supplierName;
    private final Product product;
    private final int realizedAmount;
    private final BigDecimal finalPrice;

    public OrderSummaryItem(String supplierName, Product product, int realizedAmount, BigDecimal finalPrice) {
        this.supplierName = supplierName;
        this.product = product;
        this.realizedAmount = realizedAmount;
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "OrderSummaryItem{" +
                "supplierName='" + supplierName + '\'' +
                ", product=" + product +
                ", realizedAmount=" + realizedAmount +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
