package com.shree.ecom.activityMyCart.model.dto;

public class CartContentDto {
    private int cartContextId;
    private int qty;
    private double price;
    private double tax;
    private int id;

    public int getCartContextId() {
        return cartContextId;
    }

    public void setCartContextId(int cartContextId) {
        this.cartContextId = cartContextId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
