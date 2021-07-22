package com.shree.ecom.home.model.repository.product;

import com.shree.ecom.home.model.dto.FeaturedProductEntity;
import com.shree.ecom.home.model.dto.LatestProductEntity;

import io.reactivex.Observable;

public interface FeaturedProductRepository {
    Observable<FeaturedProductEntity> getProduct();

    Observable<FeaturedProductEntity> getProductFromNetwork();

    Observable<FeaturedProductEntity> getProductFromCache();
}
