package com.shree.ecom.checkout.module;

import android.content.Context;

import com.shree.ecom.activityBrowse.services.AllEquipmentApiService;
import com.shree.ecom.checkout.service.CheckoutService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class CheckoutApiModule extends BaseApiModule {

    @Provides
    public CheckoutService provideCheckoutApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(CheckoutService.class);
    }
}
