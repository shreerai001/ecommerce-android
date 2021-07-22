package com.shree.ecom.activityRequestProduct.module;

import android.content.Context;

import com.shree.ecom.activityLogin.services.LoginApiServices;
import com.shree.ecom.activityRequestProduct.service.RequestProductApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class RequestProductApiModule extends BaseApiModule {


    @Provides
    public RequestProductApiService provideApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(RequestProductApiService.class);
    }
}
