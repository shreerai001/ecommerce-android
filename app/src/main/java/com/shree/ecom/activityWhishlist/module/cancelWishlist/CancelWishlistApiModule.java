package com.shree.ecom.activityWhishlist.module.cancelWishlist;

import android.content.Context;

import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;
import com.shree.ecom.activityWhishlist.service.CancelWishlistApiService;

import dagger.Module;
import dagger.Provides;

@Module
public class CancelWishlistApiModule extends BaseApiModule {


    @Provides
    public CancelWishlistApiService provideWishlistApiModule() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(CancelWishlistApiService.class);
    }
}
