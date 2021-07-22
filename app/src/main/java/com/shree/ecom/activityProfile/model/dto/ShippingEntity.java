package com.shree.ecom.activityProfile.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingEntity {

    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private ProfileShippingDataDto data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ProfileShippingDataDto getData() {
        return data;
    }

    public void setData(ProfileShippingDataDto data) {
        this.data = data;
    }
}
