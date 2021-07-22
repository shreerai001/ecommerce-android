package com.shree.ecom.activityProductDetail.repositories;

import com.shree.ecom.activityProductDetail.model.dto.ProductRecommendationEntity;
import com.shree.ecom.activityProductDetail.service.ProductDetailApiService;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class ProductDetailRepositoryIMPL implements ProductDetailRepository {
    private ProductDetailApiService productDetailApiService;
    private long timeStamp;
    private List<ProductRecommendationEntity> productRecommendationEntityList;

    public ProductDetailRepositoryIMPL(ProductDetailApiService productDetailApiService) {
        this.productDetailApiService = productDetailApiService;
        timeStamp = System.currentTimeMillis();
        productRecommendationEntityList = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<ProductRecommendationEntity> getProductRecommendation() {
        return getProductRecommendationFromCache().switchIfEmpty(getProductRecommendationFromNetwork());
    }

    @Override
    public Observable<ProductRecommendationEntity> getProductRecommendationFromCache() {
        if (isUpToDate()) {
            return Observable.fromIterable(productRecommendationEntityList);
        } else {
            timeStamp = System.currentTimeMillis();
            productRecommendationEntityList.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<ProductRecommendationEntity> getProductRecommendationFromNetwork() {
        return productDetailApiService.getProductRecommendation();
    }
}
