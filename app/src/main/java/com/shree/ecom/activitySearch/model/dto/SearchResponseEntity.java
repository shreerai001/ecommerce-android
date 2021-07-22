package com.shree.ecom.activitySearch.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResponseEntity {


    @Expose
    @SerializedName("products")
    private ProductsEntity products;

    public ProductsEntity getProducts() {
        return products;
    }

    public void setProducts(ProductsEntity products) {
        this.products = products;
    }
}
