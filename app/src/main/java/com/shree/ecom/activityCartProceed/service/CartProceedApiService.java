package com.shree.ecom.activityCartProceed.service;

import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface CartProceedApiService {
    @POST
    Observable<BaseResponseEntity> proceedCart(
            @Header("Authorization") String auth,
            @Field("first_name") String firstName,
            @Field("last_name") String lastName,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("address1") String address1,
            @Field("address2") String address2,
            @Field("city") String city,
            @Field("state") String state,
            @Field("country") String country,
            @Field("postcode") String postcode,
            @Field("order_note") String orderNote,
            @Field("cartContents[0][qty]") String qty,
            @Field("cartContents[0][price]") String price,
            @Field("cartContents[0][tax]") String tax,
            @Field("cartContents[0][id]") String id
    );
}
