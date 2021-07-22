package com.shree.ecom.activityLogin.services;

import com.shree.ecom.activityLogin.model.dto.LoginResponseDto;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by shree on 14,May,2019
 */
public interface LoginApiServices {
    @FormUrlEncoded
    @POST("login")
    Observable<LoginResponseDto> login(@Field("email") String email, @Field("password") String password);
}
