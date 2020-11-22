package com.kodilla.good.patterns.challenges;

public class Main {

    public static void main(String[] args) {

        User user = new User("Mike");
        Product product = new Product("Milk", 2.0);
        OrderRequest orderRequest = new OrderRequest(user, product, 10);
        ProductOrderService productOrderService = new ProductOrderService(new OrderProduct(), new MailService(), new ProductOrderRepository());

        productOrderService.process(orderRequest);
    }
}
