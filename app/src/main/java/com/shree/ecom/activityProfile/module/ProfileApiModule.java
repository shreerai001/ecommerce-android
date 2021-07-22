package com.shree.ecom.activityProfile.module;

import android.content.Context;

import com.shree.ecom.activityProfile.services.ProfileApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileApiModule extends BaseApiModule {

    @Provides
    public ProfileApiService provideProfileApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(ProfileApiService.class);
    }
}
