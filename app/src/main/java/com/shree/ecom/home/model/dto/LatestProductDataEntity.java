package com.shree.ecom.home.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LatestProductDataEntity {
    @Expose
    @SerializedName("category_id")
    private int category_id;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("products")
    private List<ProductsEntity> products;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProductsEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsEntity> products) {
        this.products = products;
    }
}
