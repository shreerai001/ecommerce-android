package com.shree.ecom.activityPasswordChange.service;

import com.shree.ecom.utils.values.BaseResponseEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ChangePasswordApiService {

    @POST("my-account/change-password")
    @FormUrlEncoded
    Call<BaseResponseEntity> changePassword(
            @Header("Authorization") String auth,
            @Field("current_password") String currentPassword,
            @Field("password") String password,
            @Field("password_confirmation") String passwordConfirmation);
}
