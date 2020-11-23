package com.kodilla.good.patterns.food2door;

public class Main {

    public static void main(String[] args) {
        Supplier extraFoodShop = new Supplier("ExtraFoodShop");
        extraFoodShop.addProduct(new Product("Milk", 20));
        extraFoodShop.addProduct(new Product("Sausage", 10));
        OrderRequest orderRequest = new OrderRequest(extraFoodShop, extraFoodShop.getProductNames().get(0), 15);
        OrderRequest orderRequest2 = new OrderRequest(extraFoodShop, extraFoodShop.getProductNames().get(0), 15);

        ProductOrderService productOrderService = new ProductOrderService(new OrderProduct(), new MailService(), new ProductOrderRepository());
        productOrderService.process(orderRequest);
        productOrderService.process(orderRequest2);
    }
}
