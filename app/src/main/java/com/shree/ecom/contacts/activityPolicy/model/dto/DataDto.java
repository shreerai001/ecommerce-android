package com.shree.ecom.contacts.activityPolicy.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataDto {
    @SerializedName("seller_condition")
    private String seller_condition;
    @SerializedName("buyer_condition")
    private String buyer_condition;
    @SerializedName("site_condition")
    private String site_condition;
    @SerializedName("privacy_policy")
    private String privacy_policy;

    public String getSeller_condition() {
        return seller_condition;
    }

    public void setSeller_condition(String seller_condition) {
        this.seller_condition = seller_condition;
    }

    public String getBuyer_condition() {
        return buyer_condition;
    }

    public void setBuyer_condition(String buyer_condition) {
        this.buyer_condition = buyer_condition;
    }

    public String getSite_condition() {
        return site_condition;
    }

    public void setSite_condition(String site_condition) {
        this.site_condition = site_condition;
    }

    public String getPrivacy_policy() {
        return privacy_policy;
    }

    public void setPrivacy_policy(String privacy_policy) {
        this.privacy_policy = privacy_policy;
    }
}
