package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.food2door.order.Order;
import com.kodilla.good.patterns.food2door.order.OrderItem;
import com.kodilla.good.patterns.food2door.order.OrderProcessor;
import com.kodilla.good.patterns.food2door.order.OrderSummary;
import com.kodilla.good.patterns.food2door.product.Product;
import com.kodilla.good.patterns.food2door.supplier.ExtraFoodShop;
import com.kodilla.good.patterns.food2door.supplier.GlutenFreeShop;
import com.kodilla.good.patterns.food2door.supplier.HealthyShop;
import com.kodilla.good.patterns.food2door.supplier.Shops;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        final Product bread = new Product("bread");
        final Product milk = new Product("milk");
        final Product cheese = new Product("cheese");
        final Product egg = new Product("egg");

        final HealthyShop healthyShop = new HealthyShop();
        healthyShop.addProduct(milk, 5, new BigDecimal("2.00"));
        healthyShop.addProduct(egg, 200, new BigDecimal("0.99"));

        final ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        extraFoodShop.addProduct(cheese, 20, new BigDecimal("15.99"));
        extraFoodShop.addProduct(milk, 50, new BigDecimal("3.20"));

        final GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        glutenFreeShop.addProduct(bread, 40, new BigDecimal("1.20"));
        glutenFreeShop.addProduct(milk, 20, new BigDecimal("1.99"));

        Shops shops = new Shops();
        shops.addShop(healthyShop);
        shops.addShop(extraFoodShop);
        shops.addShop(glutenFreeShop);

        OrderProcessor orderProcessor = new OrderProcessor(shops);

        Order order1 = new Order();
        Order order2 = new Order();
        order1.addItem(new OrderItem(bread, 10));
        order1.addItem(new OrderItem(milk, 5));
        order1.addItem(new OrderItem(egg, 20));
        order2.addItem(new OrderItem(milk, 100));

        OrderSummary orderSummary1 = orderProcessor.order(order1);
        OrderSummary orderSummary2 = orderProcessor.order(order2);

        System.out.println(healthyShop);
        System.out.println(extraFoodShop);
        System.out.println(glutenFreeShop);
        System.out.println(orderSummary1);
        System.out.println(healthyShop);
        System.out.println(extraFoodShop);
        System.out.println(glutenFreeShop);
        System.out.println(orderSummary2);
        System.out.println(healthyShop);
        System.out.println(extraFoodShop);
        System.out.println(glutenFreeShop);
    }
}
