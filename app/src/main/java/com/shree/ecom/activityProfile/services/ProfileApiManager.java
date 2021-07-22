package com.shree.ecom.activityProfile.services;

import com.shree.ecom.activityPasswordChange.service.ChangePasswordApiService;
import com.shree.ecom.utils.values.RestURL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileApiManager {


    private ProfileApiManager() {
    }


    public static ProfileApiService getAPIService() {

        return getClient(RestURL.BASE_API).create(ProfileApiService.class);
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
