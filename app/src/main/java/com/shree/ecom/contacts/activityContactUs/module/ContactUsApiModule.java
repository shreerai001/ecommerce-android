package com.shree.ecom.contacts.activityContactUs.module;

import android.content.Context;

import com.shree.ecom.contacts.activityContactUs.services.ContactUsApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shree on 16,May,2019
 */
@Module
public class ContactUsApiModule extends BaseApiModule {


    @Provides
    public ContactUsApiService provideNewsApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(ContactUsApiService.class);
    }
}
