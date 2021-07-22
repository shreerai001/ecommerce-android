package com.shree.ecom.home.model;

import com.shree.ecom.home.contract.LatestProductContract;
import com.shree.ecom.home.model.dto.LatestProductEntity;
import com.shree.ecom.home.model.repository.product.LatestProductRepository;

import io.reactivex.Observable;

public class LatestProductModel implements LatestProductContract.Model {
    private LatestProductRepository productRepository;

    public LatestProductModel(LatestProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Observable<LatestProductEntity> getProduct() {
        return productRepository.getProduct();
    }
}
