package com.shree.ecom.contacts.activityPolicy.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shree on 16,May,2019
 */
public class PolicyEntity {

    @SerializedName("error")
    private boolean error;
    @SerializedName("data")
    private DataDto data;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public DataDto getData() {
        return data;
    }

    public void setData(DataDto data) {
        this.data = data;
    }
}
