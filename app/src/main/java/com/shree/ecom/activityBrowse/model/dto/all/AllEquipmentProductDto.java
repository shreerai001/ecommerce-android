package com.shree.ecom.activityBrowse.model.dto.all;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllEquipmentProductDto {
    @Expose
    @SerializedName("img")
    private String img;
    @Expose
    @SerializedName("updated_at")
    private String updated_at;
    @Expose
    @SerializedName("created_at")
    private String created_at;
    @Expose
    @SerializedName("status")
    private int status;
    @Expose
    @SerializedName("approved")
    private int approved;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("tax")
    private int tax;
    @Expose
    @SerializedName("running_hour")
    private String running_hour;
    @Expose
    @SerializedName("brand_id")
    private int brand_id;
    @Expose
    @SerializedName("location")
    private String location;
    @Expose
    @SerializedName("ref_no")
    private String ref_no;
    @Expose
    @SerializedName("model")
    private String model;
    @Expose
    @SerializedName("manufacture_year")
    private String manufacture_year;
    @Expose
    @SerializedName("manufacture_company")
    private String manufacture_company;
    @Expose
    @SerializedName("condition")
    private String condition;
    @Expose
    @SerializedName("stock")
    private int stock;
    @Expose
    @SerializedName("stock_qty")
    private int stock_qty;
    @Expose
    @SerializedName("sale_price")
    private String sale_price;
    @Expose
    @SerializedName("price")
    private String price;
    @Expose
    @SerializedName("slug")
    private String slug;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("user_id")
    private int user_id;
    @Expose
    @SerializedName("id")
    private int id;

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
}
