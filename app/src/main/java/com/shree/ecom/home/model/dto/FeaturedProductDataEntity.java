package com.shree.ecom.home.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeaturedProductDataEntity {
    @SerializedName("products")
    private List<FeaturedProductDto> featuredProductEntity;
    private String title;
    private int category_id;

    public List<FeaturedProductDto> getFeaturedProductEntity() {
        return featuredProductEntity;
    }

    public void setFeaturedProductEntity(List<FeaturedProductDto> featuredProductEntity) {
        this.featuredProductEntity = featuredProductEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
