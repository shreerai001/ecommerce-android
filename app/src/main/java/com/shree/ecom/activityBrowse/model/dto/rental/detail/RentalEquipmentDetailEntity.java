package com.shree.ecom.activityBrowse.model.dto.rental.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RentalEquipmentDetailEntity {


    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private List<RentalDetailDataDto> data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<RentalDetailDataDto> getData() {
        return data;
    }

    public void setData(List<RentalDetailDataDto> data) {
        this.data = data;
    }
}
