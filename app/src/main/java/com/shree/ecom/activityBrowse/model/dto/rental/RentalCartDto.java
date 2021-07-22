package com.shree.ecom.activityBrowse.model.dto.rental;

import com.shree.ecom.activityBrowse.model.dto.AddressCartDto;
import com.shree.ecom.activityBrowse.model.dto.PersonalCartDto;

public class RentalCartDto {
    private int id;
    private int rental_product_id;
    private String company;
    private String productName;
    private int userId;
    private String model;
    private int brand_id;
    private String image;

    public RentalCartDto(int rental_product_id, String company, String productName, int userId, String model, int brand_id, String image) {
        this.rental_product_id = rental_product_id;
        this.company = company;
        this.productName = productName;
        this.userId = userId;
        this.model = model;
        this.brand_id = brand_id;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRental_product_id() {
        return rental_product_id;
    }

    public void setRental_product_id(int rental_product_id) {
        this.rental_product_id = rental_product_id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }
}
