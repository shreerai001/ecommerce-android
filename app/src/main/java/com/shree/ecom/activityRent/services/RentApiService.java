package com.shree.ecom.activityRent.services;

import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RentApiService {

    @POST("rent-product")
    @FormUrlEncoded
    Observable<BaseResponseEntity> rentPrdouct(
            @Header("Authorization") String auth,
            @Field("rental_product_id") String id,
            @Field("company") String company,
            @Field("first_name") String firstName,
            @Field("last_name") String lastName,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("address") String address,
            @Field("city") String city,
            @Field("state") String state,
            @Field("zip_code") String zipCode,
            @Field("message") String message
    );
}
