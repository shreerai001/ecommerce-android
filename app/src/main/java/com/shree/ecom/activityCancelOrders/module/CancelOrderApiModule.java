package com.shree.ecom.activityCancelOrders.module;

import android.content.Context;

import com.shree.ecom.activityCancelOrders.services.CancelOrderContractApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class CancelOrderApiModule extends BaseApiModule {


    @Provides
    public CancelOrderContractApiService provideCancelOrderApi() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(CancelOrderContractApiService.class);
    }
}
