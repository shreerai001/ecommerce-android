package com.shree.ecom.activityProductDetail.module;

import android.content.Context;

import com.shree.ecom.activityProductDetail.contract.ProductDetailContract;
import com.shree.ecom.activityProductDetail.model.ProductDetailModel;
import com.shree.ecom.activityProductDetail.presenter.ProductDetailPresenter;
import com.shree.ecom.activityProductDetail.repositories.ProductDetailRepository;
import com.shree.ecom.activityProductDetail.repositories.ProductDetailRepositoryIMPL;
import com.shree.ecom.activityProductDetail.service.ProductDetailApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductDetailModule {
    @Provides
    public ProductDetailContract.Model providesModel(ProductDetailRepository productDetailRepository, Context context) {
        return new ProductDetailModel(productDetailRepository, context);
    }

    @Provides
    public ProductDetailContract.Presenter providesPresenter(ProductDetailContract.Model productDetailModel) {
        return new ProductDetailPresenter(productDetailModel);
    }

    @Singleton
    @Provides
    public ProductDetailRepository provideRepo(ProductDetailApiService productDetailApiService) {
        return new ProductDetailRepositoryIMPL(productDetailApiService);
    }
}
