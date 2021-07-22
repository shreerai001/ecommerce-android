package com.shree.ecom.activityMyOrders.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyOrdersEntity {

    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private List<MyOrdersDataEntity> data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<MyOrdersDataEntity> getData() {
        return data;
    }

    public void setData(List<MyOrdersDataEntity> data) {
        this.data = data;
    }
}
