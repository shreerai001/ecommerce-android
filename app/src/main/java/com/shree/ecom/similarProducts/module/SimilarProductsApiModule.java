package com.shree.ecom.similarProducts.module;

import android.content.Context;

import com.shree.ecom.activityProductDetail.service.ProductDetailApiService;
import com.shree.ecom.similarProducts.service.SimilarProductsApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class SimilarProductsApiModule extends BaseApiModule {

    @Provides
    public SimilarProductsApiService provideApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(SimilarProductsApiService.class);
    }
}
