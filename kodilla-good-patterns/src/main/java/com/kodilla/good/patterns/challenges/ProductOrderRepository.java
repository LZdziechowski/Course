package com.kodilla.good.patterns.challenges;

public class ProductOrderRepository implements OrderRepository{

    @Override
    public boolean createOrder(OrderRequest orderRequest) {

        //save in repo logic
        System.out.println("Order saved.");
        //return true temporary
        return true;
    }
}
