package com.shree.ecom.activityBrowse.model.dto.rental;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RentalDataDto {
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
    @SerializedName("hours")
    private String hours;
    @Expose
    @SerializedName("brand_id")
    private int brand_id;
    @Expose
    @SerializedName("rental_location")
    private String rental_location;
    @Expose
    @SerializedName("location")
    private String location;
    @Expose
    @SerializedName("month_price")
    private String month_price;
    @Expose
    @SerializedName("day_price")
    private String day_price;
    @Expose
    @SerializedName("hour_price")
    private String hour_price;
    @Expose
    @SerializedName("negotiable")
    private String negotiable;
    @Expose
    @SerializedName("ref_no")
    private String ref_no;
    @Expose
    @SerializedName("model")
    private String model;
    @Expose
    @SerializedName("manufacture_year")
    private int manufacture_year;
    @Expose
    @SerializedName("manufacture_company")
    private String manufacture_company;
    @Expose
    @SerializedName("condition")
    private String condition;
    @Expose
    @SerializedName("slug")
    private String slug;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("category_id")
    private int category_id;
    @Expose
    @SerializedName("user_id")
    private int user_id;
    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("img")
    private String img;

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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getRental_location() {
        return rental_location;
    }

    public void setRental_location(String rental_location) {
        this.rental_location = rental_location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMonth_price() {
        return month_price;
    }

    public void setMonth_price(String month_price) {
        this.month_price = month_price;
    }

    public String getDay_price() {
        return day_price;
    }

    public void setDay_price(String day_price) {
        this.day_price = day_price;
    }

    public String getHour_price() {
        return hour_price;
    }

    public void setHour_price(String hour_price) {
        this.hour_price = hour_price;
    }

    public String getNegotiable() {
        return negotiable;
    }

    public void setNegotiable(String negotiable) {
        this.negotiable = negotiable;
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

    public int getManufacture_year() {
        return manufacture_year;
    }

    public void setManufacture_year(int manufacture_year) {
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
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
