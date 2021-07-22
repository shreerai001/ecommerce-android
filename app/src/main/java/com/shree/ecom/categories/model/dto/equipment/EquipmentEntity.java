package com.shree.ecom.categories.model.dto.equipment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EquipmentEntity {

    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private List<EquipmentDto> data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<EquipmentDto> getData() {
        return data;
    }

    public void setData(List<EquipmentDto> data) {
        this.data = data;
    }
}
