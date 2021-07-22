package com.shree.ecom.activityRequestProduct.service;

import com.shree.ecom.activityRequestProduct.model.dto.RequestProductEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RequestProductApiService {
    @POST("request-product")
    @FormUrlEncoded
    Observable<BaseResponseEntity> requestProduct(
            @Header("Authorization") String auth,
            @Field("category_id") String id,
            @Field("brand_id") String brandId,
            @Field("first_name") String firstName,
            @Field("phone") String phone,
            @Field("last_name") String lastName,
            @Field("company") String company,
            @Field("email") String email,
            @Field("model") String model,
            @Field("purpose") String purpose,
            @Field("condition") String condition,
            @Field("price") String price,
            @Field("manufacture_company") String manufactureCompany,
            @Field("message") String message,
            @Field("year") String year,
            @Field("hour") String hour
    );
}
