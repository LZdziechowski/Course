package com.kodilla.good.patterns.food2door.product;

import java.math.BigDecimal;

public class ProductDetails {

    private final Product product;

    private int amount;

    private BigDecimal price;

    public ProductDetails(Product product, int amount, BigDecimal price) {
        this.product = product;
        this.amount = amount;
        this.price = price;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public boolean removeAmount(int amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return true;
        }
        return false;
    }

    public int reserveAmount(int amount) {
        final int available = this.getAmount();
        if(available >= amount){
            this.amount -= amount;
            return amount;
        }
        this.amount = 0;
        return available;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "product=" + product +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
