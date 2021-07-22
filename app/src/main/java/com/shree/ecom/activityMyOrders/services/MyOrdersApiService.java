package com.shree.ecom.activityMyOrders.services;

import com.shree.ecom.activityMyOrders.model.dto.MyOrdersEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface MyOrdersApiService {
    @GET("my-account/orders")
    Observable<MyOrdersEntity> getMyEntity(@Header("Authorization") String token);
}
