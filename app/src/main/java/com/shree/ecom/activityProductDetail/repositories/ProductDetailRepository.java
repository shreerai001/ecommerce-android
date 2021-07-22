package com.shree.ecom.activityProductDetail.repositories;

import com.shree.ecom.activityProductDetail.model.dto.ProductRecommendationEntity;

import io.reactivex.Observable;

public interface ProductDetailRepository {
    Observable<ProductRecommendationEntity> getProductRecommendation();

    Observable<ProductRecommendationEntity> getProductRecommendationFromCache();

    Observable<ProductRecommendationEntity> getProductRecommendationFromNetwork();
}
