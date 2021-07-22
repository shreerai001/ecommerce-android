package com.shree.ecom.categories.module.api;

import android.content.Context;

import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.categories.services.CategoryApiService;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class EquipmentApiModule extends BaseApiModule {

    @Provides
    public CategoryApiService provideCategoryApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(CategoryApiService.class);
    }
}
