package com.shree.ecom.home.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LatestProductEntity {

    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private LatestProductDataEntity data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public LatestProductDataEntity getData() {
        return data;
    }

    public void setData(LatestProductDataEntity data) {
        this.data = data;
    }
}
