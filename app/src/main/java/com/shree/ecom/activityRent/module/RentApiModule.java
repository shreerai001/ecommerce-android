package com.shree.ecom.activityRent.module;

import android.content.Context;

import com.shree.ecom.activityRent.services.RentApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class RentApiModule extends BaseApiModule {


    @Provides
    public RentApiService provideRentApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(RentApiService.class);
    }
}
