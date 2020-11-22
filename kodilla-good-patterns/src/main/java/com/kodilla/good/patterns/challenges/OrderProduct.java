package com.kodilla.good.patterns.challenges;

public class OrderProduct implements OrderService{
    @Override
    public boolean order(User user, Product product, int quantity) {

        //product order logic
        System.out.println("Product ordered");
        //return true temporary
        return true;
    }
}
