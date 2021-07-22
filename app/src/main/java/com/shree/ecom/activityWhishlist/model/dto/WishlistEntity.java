package com.shree.ecom.activityWhishlist.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WishlistEntity {

    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private List<WishlistDataEntity> data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<WishlistDataEntity> getData() {
        return data;
    }

    public void setData(List<WishlistDataEntity> data) {
        this.data = data;
    }
}
