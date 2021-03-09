package com.kodilla.good.patterns.food2door.supplier;

import com.kodilla.good.patterns.food2door.order.OrderItem;
import com.kodilla.good.patterns.food2door.order.OrderSummaryItem;
import com.kodilla.good.patterns.food2door.product.Product;
import com.kodilla.good.patterns.food2door.product.ProductDetails;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractSupplier implements Supplier{

    private String name = "Abstract";

    protected final Map<Product, ProductDetails> products = new HashMap<>();

    public void addProduct(Product product, int amount, BigDecimal price) {
        if (products.containsKey(product)) {
            products.get(product).addAmount(amount);
            products.get(product).setPrice(price);
        } else {
            products.put(product, new ProductDetails(product, amount, price));
        }
    }

    @Override
    public int reserveProduct(Product product, int amount) {
        if(products.containsKey(product)) {
            return products.get(product).reserveAmount(amount);
        }
        return 0;
    }

    @Override
    public Optional<BigDecimal> getPrice(Product product) {
        return Optional.ofNullable(products.get(product).getPrice());
    }

    @Override
    public String toString() {
        return "Shop=" + name + ", products=" + products;
    }
}
