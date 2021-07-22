package com.shree.ecom.activityLogin.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponseDto {

    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private LoginDto data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public LoginDto getData() {
        return data;
    }

    public void setData(LoginDto data) {
        this.data = data;
    }
}
