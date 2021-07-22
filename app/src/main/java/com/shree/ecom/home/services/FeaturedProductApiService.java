package com.shree.ecom.home.services;

import com.shree.ecom.home.model.dto.FeaturedProductEntity;
import com.shree.ecom.home.model.dto.LatestProductEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface FeaturedProductApiService {

    @GET("products-section2")
    Observable<FeaturedProductEntity> getLatestProduct();
}
