package com.shree.ecom.reviews.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReviewsDataDto {
    @Expose
    @SerializedName("date")
    private String date;
    @Expose
    @SerializedName("fullname")
    private String fullname;
    @Expose
    @SerializedName("image")
    private String image;
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
    @SerializedName("comment")
    private String comment;
    @Expose
    @SerializedName("star")
    private int star;
    @Expose
    @SerializedName("product_id")
    private int product_id;
    @Expose
    @SerializedName("user_id")
    private int user_id;
    @Expose
    @SerializedName("id")
    private int id;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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
