package com.shree.ecom.activityCancelOrders.services;

import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface CancelOrderContractApiService {
    @GET("my-account/order/{id}/cancel")
    Observable<BaseResponseEntity> getReviews(@Header("Authorization") String auth, @Path("id") String id);
}
