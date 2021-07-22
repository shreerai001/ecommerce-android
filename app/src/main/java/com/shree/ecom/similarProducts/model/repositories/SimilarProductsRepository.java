package com.shree.ecom.similarProducts.model.repositories;

import com.shree.ecom.similarProducts.model.dto.SimilarProductsEntity;

import java.util.List;

import io.reactivex.Observable;

public interface SimilarProductsRepository {
    Observable<List<SimilarProductsEntity>> getSimilarProducts(String id);

    Observable<List<SimilarProductsEntity>> getSimilarProductsFromCache();

    Observable<List<SimilarProductsEntity>> getSimilarProductsFromNetwork(String id);
}
