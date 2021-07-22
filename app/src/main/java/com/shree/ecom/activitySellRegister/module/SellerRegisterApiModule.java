package com.shree.ecom.activitySellRegister.module;

import android.content.Context;

import com.shree.ecom.activitySearch.service.SearchApiService;
import com.shree.ecom.activitySellRegister.service.RegisterSellApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class SellerRegisterApiModule extends BaseApiModule {


    @Provides
    public RegisterSellApiService provideApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(RegisterSellApiService.class);
    }
}
