package com.shree.ecom.activityWhishlist.module.addWishlist;

import android.content.Context;

import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;
import com.shree.ecom.activityWhishlist.service.WishlistApiService;

import dagger.Module;
import dagger.Provides;

@Module
public class WishlistApiModule extends BaseApiModule {

    @Provides
    public WishlistApiService provideWishlistApiModule() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(WishlistApiService.class);
    }
}
