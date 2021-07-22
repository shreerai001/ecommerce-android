package com.shree.ecom.contacts.activityPolicy.module;

import android.content.Context;

import com.shree.ecom.contacts.activityPolicy.services.PolicyApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shree on 16,May,2019
 */
@Module
public class PolicyApiModule extends BaseApiModule {


    @Provides
    public PolicyApiService provideCategoryApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(PolicyApiService.class);
    }
}
