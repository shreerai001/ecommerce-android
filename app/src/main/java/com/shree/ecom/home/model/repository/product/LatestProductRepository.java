package com.shree.ecom.home.model.repository.product;

import com.shree.ecom.home.model.dto.LatestProductEntity;

import io.reactivex.Observable;

public interface LatestProductRepository {
    Observable<LatestProductEntity> getProduct();

    Observable<LatestProductEntity> getProductFromNetwork();

    Observable<LatestProductEntity> getProductFromCache();
}
