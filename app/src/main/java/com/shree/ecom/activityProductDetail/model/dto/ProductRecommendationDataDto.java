package com.shree.ecom.activityProductDetail.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductRecommendationDataDto {
    @Expose
    @SerializedName("wishlist")
    private int wishlist;
    @Expose
    @SerializedName("similarProducts")
    private List<SimilarProductsDto> similarProducts;
    @Expose
    @SerializedName("shop_name")
    private String shop_name;
    @Expose
    @SerializedName("tax")
    private int tax;
    @Expose
    @SerializedName("id")
    private int id;

    public int getWishlist() {
        return wishlist;
    }

    public void setWishlist(int wishlist) {
        this.wishlist = wishlist;
    }

    public List<SimilarProductsDto> getSimilarProducts() {
        return similarProducts;
    }

    public void setSimilarProducts(List<SimilarProductsDto> similarProducts) {
        this.similarProducts = similarProducts;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
