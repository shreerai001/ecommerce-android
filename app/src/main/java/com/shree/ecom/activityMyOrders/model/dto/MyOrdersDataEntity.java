package com.shree.ecom.activityMyOrders.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyOrdersDataEntity {
    @Expose
    @SerializedName("grandtotal")
    private int grandtotal;
    @Expose
    @SerializedName("tax")
    private int tax;
    @Expose
    @SerializedName("subtotal")
    private int subtotal;
    @Expose
    @SerializedName("orderProducts")
    private List<OrderProductsEntity> orderProducts;
    @Expose
    @SerializedName("order_date")
    private String order_date;
    @Expose
    @SerializedName("order_status")
    private String order_status;
    @Expose
    @SerializedName("id")
    private int id;

    public int getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(int grandtotal) {
        this.grandtotal = grandtotal;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public List<OrderProductsEntity> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductsEntity> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
