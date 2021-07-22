package com.shree.ecom.activityPasswordChange.service;

import com.shree.ecom.utils.values.RestURL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {


    private ApiManager() {
    }


    public static ChangePasswordApiService getAPIService() {

        return getClient(RestURL.BASE_API).create(ChangePasswordApiService.class);
    }


    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
