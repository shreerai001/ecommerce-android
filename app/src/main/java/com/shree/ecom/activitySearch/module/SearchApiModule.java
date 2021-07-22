package com.shree.ecom.activitySearch.module;

import android.content.Context;

import com.shree.ecom.activityLogin.services.LoginApiServices;
import com.shree.ecom.activitySearch.service.SearchApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchApiModule extends BaseApiModule {

    @Provides
    public SearchApiService provideApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(SearchApiService.class);
    }
}
