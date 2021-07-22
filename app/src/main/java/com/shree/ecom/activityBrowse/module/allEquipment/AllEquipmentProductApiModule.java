package com.shree.ecom.activityBrowse.module.allEquipment;

import android.content.Context;

import com.shree.ecom.activityBrowse.services.AllEquipmentApiService;
import com.shree.ecom.utils.di.BaseApiModule;
import com.shree.ecom.utils.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class AllEquipmentProductApiModule extends BaseApiModule {

    @Provides
    public AllEquipmentApiService provideRentalApiService() {
        return provideRetrofit(RestURL.BASE_API, provideOkHttp()).create(AllEquipmentApiService.class);
    }
}
