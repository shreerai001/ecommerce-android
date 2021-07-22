package com.shree.ecom.activityProfile.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileEntity {


    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private ProfileDataDto data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ProfileDataDto getData() {
        return data;
    }

    public void setData(ProfileDataDto data) {
        this.data = data;
    }
}
