package com.shree.ecom.activityWhishlist.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WishlistDataEntity {
    @Expose
    @SerializedName("product_image")
    private String product_image;
    @Expose
    @SerializedName("sale_price")
    private String sale_price;
    @Expose
    @SerializedName("product_price")
    private String product_price;
    @Expose
    @SerializedName("product_name")
    private String product_name;
    @Expose
    @SerializedName("product_id")
    private int product_id;
    @Expose
    @SerializedName("date")
    private String date;
    @Expose
    @SerializedName("id")
    private int id;

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
