package com.shree.ecom.utils.values;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shree on 14,May,2019
 */
public class ErrorEntity extends RuntimeException {

    @Expose
    @SerializedName("errors")
    private Errors errors;

    public static class Errors {
        @Expose
        @SerializedName("email")
        private List<String> email;
    }
}
