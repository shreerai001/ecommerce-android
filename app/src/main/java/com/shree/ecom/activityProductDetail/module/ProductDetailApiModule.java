package com.shree.ecom.activityProductDetail.module;

import android.content.Context;

import com.shree.ecom.activityProductDetail.service.ProductDetailApiService;
import com.shree.ecom.activityProfile.services.ProfileApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductDetailApiModule extends BaseApiModule {

    @Provides
    public ProductDetailApiService provideApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(ProductDetailApiService.class);
    }
}
