package com.shree.ecom.activityProductDetail.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductRecommendationEntity {

    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private ProductRecommendationDataDto data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ProductRecommendationDataDto getData() {
        return data;
    }

    public void setData(ProductRecommendationDataDto data) {
        this.data = data;
    }
}
