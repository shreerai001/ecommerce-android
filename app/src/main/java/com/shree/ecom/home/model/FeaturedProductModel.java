package com.shree.ecom.home.model;

import com.shree.ecom.home.contract.FeaturedProductContract;
import com.shree.ecom.home.contract.LatestProductContract;
import com.shree.ecom.home.model.dto.FeaturedProductEntity;
import com.shree.ecom.home.model.dto.LatestProductEntity;
import com.shree.ecom.home.model.repository.product.FeaturedProductRepository;
import com.shree.ecom.home.model.repository.product.LatestProductRepository;

import io.reactivex.Observable;

public class FeaturedProductModel implements FeaturedProductContract.Model {
    private FeaturedProductRepository productRepository;

    public FeaturedProductModel(FeaturedProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Observable<FeaturedProductEntity> getFeaturedProduct() {
        return productRepository.getProduct();
    }
}
