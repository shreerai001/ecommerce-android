package com.shree.ecom.activitySearch.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImgsEntity {
    @Expose
    @SerializedName("largeUrl")
    private String largeUrl;
    @Expose
    @SerializedName("mediumUrl")
    private String mediumUrl;
    @Expose
    @SerializedName("smallUrl")
    private String smallUrl;
    @Expose
    @SerializedName("url")
    private String url;
    @Expose
    @SerializedName("relativePath")
    private String relativePath;

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }
}
