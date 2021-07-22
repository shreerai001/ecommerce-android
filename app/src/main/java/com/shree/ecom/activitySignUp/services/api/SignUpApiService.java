package com.shree.ecom.activitySignUp.services.api;

import com.shree.ecom.utils.values.AuthEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by shree on 13,May,2019
 */
public interface SignUpApiService {

    @FormUrlEncoded
    @POST("register")
    Observable<AuthEntity> signUP(@Field("first_name") String firstName,
                                  @Field("last_name") String lastName,
                                  @Field("phone") String phone,
                                  @Field("email") String email,
                                  @Field("password") String password,
                                  @Field("password_confirmation") String passwordConfirmation);
}
