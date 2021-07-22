package com.shree.ecom.activityMain.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categories {
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("error")
    @Expose
    private Boolean error;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}
