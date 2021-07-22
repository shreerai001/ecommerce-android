package com.shree.ecom.activityProductDetail.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductsImgsDto;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductImgsDto;

import java.util.List;

public class ProductDetailEntity {
    private String img;
    private String updated_at;
    private String created_at;
    private int status;
    private int approved;
    private String description;
    private int tax;
    private String running_hour;
    private int brand_id;
    private String location;
    private String ref_no;
    private String model;
    private String manufacture_year;
    private String manufacture_company;
    private String condition;
    private int stock;
    private int stock_qty;
    private String sale_price;
    private String price;
    private String slug;
    private String name;
    private int user_id;
    private int id;
    private List<NewProductsImgsDto> imgs;
    private int category_id;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getRunning_hour() {
        return running_hour;
    }

    public void setRunning_hour(String running_hour) {
        this.running_hour = running_hour;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRef_no() {
        return ref_no;
    }

    public void setRef_no(String ref_no) {
        this.ref_no = ref_no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacture_year() {
        return manufacture_year;
    }

    public void setManufacture_year(String manufacture_year) {
        this.manufacture_year = manufacture_year;
    }

    public String getManufacture_company() {
        return manufacture_company;
    }

    public void setManufacture_company(String manufacture_company) {
        this.manufacture_company = manufacture_company;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock_qty() {
        return stock_qty;
    }

    public void setStock_qty(int stock_qty) {
        this.stock_qty = stock_qty;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<NewProductsImgsDto> getImgs() {
        return imgs;
    }

    public void setImgs(List<NewProductsImgsDto> imgs) {
        this.imgs = imgs;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
