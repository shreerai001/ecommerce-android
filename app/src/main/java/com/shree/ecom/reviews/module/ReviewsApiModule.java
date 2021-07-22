package com.shree.ecom.reviews.module;

import android.content.Context;

import com.shree.ecom.reviews.service.ReviewsApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;


import dagger.Module;
import dagger.Provides;

@Module
public class ReviewsApiModule extends BaseApiModule {

    @Provides
    public ReviewsApiService provideRentalApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(ReviewsApiService.class);
    }
}
