package com.shree.ecom.activityBrowse.model.dto.used;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class UsedProductEntity {

    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private List<UsedProductDataDto> data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<UsedProductDataDto> getData() {
        return data;
    }

    public void setData(List<UsedProductDataDto> data) {
        this.data = data;
    }
}
