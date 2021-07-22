package com.shree.ecom.similarProducts.model;

import com.shree.ecom.similarProducts.contract.SimilarProductsContract;
import com.shree.ecom.similarProducts.model.dto.SimilarProductsEntity;
import com.shree.ecom.similarProducts.model.repositories.SimilarProductsRepository;

import java.util.List;

import io.reactivex.Observable;

public class SimilarProductsModel implements SimilarProductsContract.Model {
    private SimilarProductsRepository similarProductsRepository;

    public SimilarProductsModel(SimilarProductsRepository similarProductsRepository) {
        this.similarProductsRepository = similarProductsRepository;
    }


    @Override
    public Observable<List<SimilarProductsEntity>> getSimilarProducts(String id) {
        return similarProductsRepository.getSimilarProducts(id);
    }
}
