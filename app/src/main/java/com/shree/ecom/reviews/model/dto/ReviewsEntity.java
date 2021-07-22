package com.shree.ecom.reviews.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewsEntity {

    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private List<ReviewsDataDto> data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ReviewsDataDto> getData() {
        return data;
    }

    public void setData(List<ReviewsDataDto> data) {
        this.data = data;
    }
}
