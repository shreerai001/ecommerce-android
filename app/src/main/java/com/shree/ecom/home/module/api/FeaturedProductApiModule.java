package com.shree.ecom.home.module.api;

import android.content.Context;

import com.shree.ecom.home.services.FeaturedProductApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class FeaturedProductApiModule extends BaseApiModule {

    @Provides
    public FeaturedProductApiService provideProductApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(FeaturedProductApiService.class);
    }
}
