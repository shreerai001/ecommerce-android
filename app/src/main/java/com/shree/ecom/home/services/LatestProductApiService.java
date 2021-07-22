package com.shree.ecom.home.services;

import com.shree.ecom.home.model.dto.LatestProductEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LatestProductApiService {

    @GET("products-section1")
    Observable<LatestProductEntity> getLatestProduct();
}
