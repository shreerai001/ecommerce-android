package com.shree.ecom.activityProfile.services;

import com.shree.ecom.activityProfile.model.dto.ProfileEntity;
import com.shree.ecom.activityProfile.model.dto.ShippingEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import java.io.File;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProfileApiService {

    @GET("my-account/view-account")
    Observable<ProfileEntity> getProfileDetail(@Header("Authorization") String Auth);

    @GET("my-account")
    Observable<ShippingEntity> getShippingDetail(@Header("Authorization") String Auth);

    @POST("my-account/edit-address/{id}")
    @FormUrlEncoded
    Call<BaseResponseEntity> changeDetail(
            @Header("Authorization") String auth,
            @Path("id") String id,
            @Field("first_name") String firstName,
            @Field("last_name") String lastName,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("address1") String address1,
            @Field("address2") String address2,
            @Field("city") String city,
            @Field("state") String state,
            @Field("country") String country,
            @Field("postcode") String postCode);
}
