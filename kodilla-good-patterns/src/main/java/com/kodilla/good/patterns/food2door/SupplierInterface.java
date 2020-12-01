package com.kodilla.good.patterns.food2door;

import java.util.Map;

public interface SupplierInterface {

    String getName();
    String getEmail();
    Map<Product, Integer> getProducts();
    OrderDTO process(OrderRequest orderRequest);
}
