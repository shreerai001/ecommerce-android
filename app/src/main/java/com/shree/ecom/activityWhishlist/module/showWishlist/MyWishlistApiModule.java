package com.shree.ecom.activityWhishlist.module.showWishlist;

import android.content.Context;

import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;
import com.shree.ecom.activityWhishlist.service.MyWishlistApiService;

import dagger.Module;
import dagger.Provides;

@Module
public class MyWishlistApiModule extends BaseApiModule {


    @Provides
    public MyWishlistApiService provideMyWishlistApiModule() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(MyWishlistApiService.class);
    }
}
