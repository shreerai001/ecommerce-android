package com.shree.ecom.activityBrowse.model.dto.rental;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RentalEquipmentEntity {

    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private List<RentalDataDto> data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<RentalDataDto> getData() {
        return data;
    }

    public void setData(List<RentalDataDto> data) {
        this.data = data;
    }
}
