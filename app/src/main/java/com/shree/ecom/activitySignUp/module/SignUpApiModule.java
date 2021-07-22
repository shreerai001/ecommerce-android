package com.shree.ecom.activitySignUp.module;

import com.shree.ecom.activitySignUp.services.api.SignUpApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shree on 14,May,2019
 */
@Module
public class SignUpApiModule extends BaseApiModule {

    @Provides
    public SignUpApiService provideNewsApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(SignUpApiService.class);
    }
}
