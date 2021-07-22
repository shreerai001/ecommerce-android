package com.shree.ecom.activityProductDetail.service;

import com.shree.ecom.activityProductDetail.model.dto.ProductRecommendationEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ProductDetailApiService {

    @GET("")
    Observable<ProductRecommendationEntity> getProductRecommendation();
}
