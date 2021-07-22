package com.shree.ecom.activityLogin.module;

import android.content.Context;

import com.shree.ecom.activityLogin.services.LoginApiServices;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shree on 14,May,2019
 */
@Module
public class LoginApiModule extends BaseApiModule {


    @Provides
    public LoginApiServices provideNewsApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(LoginApiServices.class);
    }
}
