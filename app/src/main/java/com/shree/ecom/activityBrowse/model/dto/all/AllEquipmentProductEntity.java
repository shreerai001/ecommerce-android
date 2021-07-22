package com.shree.ecom.activityBrowse.model.dto.all;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllEquipmentProductEntity {


    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private List<AllEquipmentProductDto> data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<AllEquipmentProductDto> getData() {
        return data;
    }

    public void setData(List<AllEquipmentProductDto> data) {
        this.data = data;
    }
}
