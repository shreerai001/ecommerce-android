package com.shree.ecom.activityMyOrders.module;

import android.content.Context;

import com.shree.ecom.activityMyOrders.services.MyOrdersApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class MyOrdersApiModule extends BaseApiModule {


    @Provides
    public MyOrdersApiService provideRentalApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(MyOrdersApiService.class);
    }
}
