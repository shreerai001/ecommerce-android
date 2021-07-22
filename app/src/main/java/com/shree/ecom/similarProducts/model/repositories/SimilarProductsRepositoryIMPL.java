package com.shree.ecom.similarProducts.model.repositories;

import android.content.Context;

import com.shree.ecom.similarProducts.model.dto.SimilarProductsEntity;
import com.shree.ecom.similarProducts.service.SimilarProductsApiService;
import com.shree.ecom.utils.mvp.BaseRepository;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;

import java.util.List;

import io.reactivex.Observable;

public class SimilarProductsRepositoryIMPL extends BaseRepositoryIMPL implements SimilarProductsRepository {
    private SimilarProductsApiService similarProductsApiService;
    private Context context;

    public SimilarProductsRepositoryIMPL(Context context, SimilarProductsApiService similarProductsApiService) {
        super(context);
        this.context = context;
        this.similarProductsApiService = similarProductsApiService;
    }

    @Override
    public Observable<List<SimilarProductsEntity>> getSimilarProducts(String id) {
        return similarProductsApiService.getSimilarProducts("Bearer " + super.accessToken(context), id);

    }

    @Override
    public Observable<List<SimilarProductsEntity>> getSimilarProductsFromCache() {
        return null;
    }

    @Override
    public Observable<List<SimilarProductsEntity>> getSimilarProductsFromNetwork(String id) {
        return null;
    }
}
