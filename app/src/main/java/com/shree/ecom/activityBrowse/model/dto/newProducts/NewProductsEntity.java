package com.shree.ecom.activityBrowse.model.dto.newProducts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewProductsEntity {

    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private List<NewProductDataDto> data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<NewProductDataDto> getData() {
        return data;
    }

    public void setData(List<NewProductDataDto> data) {
        this.data = data;
    }
}
