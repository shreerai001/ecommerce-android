package com.shree.ecom.activityMain.module;

import android.content.Context;

import com.shree.ecom.activityMain.ActivityMainApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityMainApiModule extends BaseApiModule {


    @Provides
    public ActivityMainApiService provideRentalApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(ActivityMainApiService.class);
    }
}
