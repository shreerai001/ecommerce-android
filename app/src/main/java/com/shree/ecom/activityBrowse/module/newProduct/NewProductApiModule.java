package com.shree.ecom.activityBrowse.module.newProduct;

import android.content.Context;

import com.shree.ecom.activityBrowse.services.NewProductApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class NewProductApiModule extends BaseApiModule {


    @Provides
    public NewProductApiService provideRentalApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(NewProductApiService.class);
    }
}
