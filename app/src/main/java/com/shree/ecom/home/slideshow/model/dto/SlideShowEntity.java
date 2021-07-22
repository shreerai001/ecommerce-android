package com.shree.ecom.home.slideshow.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SlideShowEntity {


    @Expose
    @SerializedName("error")
    private boolean error;
    @Expose
    @SerializedName("data")
    private List<SlideshowDataDto> data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<SlideshowDataDto> getData() {
        return data;
    }

    public void setData(List<SlideshowDataDto> data) {
        this.data = data;
    }
}
