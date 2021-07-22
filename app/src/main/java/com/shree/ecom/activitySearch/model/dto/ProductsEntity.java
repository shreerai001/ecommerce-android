package com.shree.ecom.activitySearch.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsEntity {
    @Expose
    @SerializedName("total")
    private int total;
    @Expose
    @SerializedName("to")
    private int to;
    @Expose
    @SerializedName("per_page")
    private int per_page;
    @Expose
    @SerializedName("path")
    private String path;
    @Expose
    @SerializedName("last_page_url")
    private String last_page_url;
    @Expose
    @SerializedName("last_page")
    private int last_page;
    @Expose
    @SerializedName("from")
    private int from;
    @Expose
    @SerializedName("first_page_url")
    private String first_page_url;
    @Expose
    @SerializedName("data")
    private List<SearchDataDto> data;
    @Expose
    @SerializedName("current_page")
    private int current_page;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLast_page_url() {
        return last_page_url;
    }

    public void setLast_page_url(String last_page_url) {
        this.last_page_url = last_page_url;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public String getFirst_page_url() {
        return first_page_url;
    }

    public void setFirst_page_url(String first_page_url) {
        this.first_page_url = first_page_url;
    }

    public List<SearchDataDto> getData() {
        return data;
    }

    public void setData(List<SearchDataDto> data) {
        this.data = data;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }
}
