package com.shree.ecom.activityBrowse.module.usedProduct;

import android.content.Context;

import com.shree.ecom.activityBrowse.services.UsedProductApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class UsedProductApiModule extends BaseApiModule {


    @Provides
    public UsedProductApiService provideUsedApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(UsedProductApiService.class);
    }
}
