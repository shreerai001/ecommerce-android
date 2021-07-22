package com.shree.ecom.activityCartProceed.module;

import android.content.Context;

import com.shree.ecom.activityCartProceed.service.CartProceedApiService;
import com.shree.ecom.activitySignUp.services.api.SignUpApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class CartApiModule extends BaseApiModule {


    @Provides
    public CartProceedApiService provideNewsApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(CartProceedApiService.class);
    }
}
