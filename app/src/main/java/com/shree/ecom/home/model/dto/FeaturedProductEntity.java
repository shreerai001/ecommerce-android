package com.shree.ecom.home.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeaturedProductEntity {

    @Expose
    @SerializedName("data")
    private FeaturedProductDataEntity data;
    @SerializedName("error")
    private boolean error;

    public FeaturedProductDataEntity getData() {
        return data;
    }

    public void setData(FeaturedProductDataEntity data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
