package com.shree.ecom.activityBrowse.module.rental;

import android.content.Context;

import com.shree.ecom.activityBrowse.services.RentalApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class RentalApiModule extends BaseApiModule {


    @Provides
    public RentalApiService provideRentalApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(RentalApiService.class);
    }
}
