package com.shree.ecom.activityBrowse.module.usedProduct;

import android.content.Context;

import com.shree.ecom.activityBrowse.contract.AllProductContract;
import com.shree.ecom.activityBrowse.contract.UsedProductContract;
import com.shree.ecom.activityBrowse.model.AllEquipmentProductModel;
import com.shree.ecom.activityBrowse.model.UsedProductModel;
import com.shree.ecom.activityBrowse.model.repositories.all.AllEquipmentProductRepository;
import com.shree.ecom.activityBrowse.model.repositories.all.AllEquipmentProductRepositoryIMPL;
import com.shree.ecom.activityBrowse.model.repositories.used.UsedPoductRepository;
import com.shree.ecom.activityBrowse.model.repositories.used.UsedProductRepositoryIMPL;
import com.shree.ecom.activityBrowse.presenter.AllEquipmentProductPresenter;
import com.shree.ecom.activityBrowse.presenter.UsedProductPresenter;
import com.shree.ecom.activityBrowse.services.AllEquipmentApiService;
import com.shree.ecom.activityBrowse.services.UsedProductApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UsedProductModule {

    @Provides
    public UsedProductContract.Model provideModle(UsedPoductRepository usedPoductRepository) {
        return new UsedProductModel(usedPoductRepository);
    }

    @Provides
    public UsedProductContract.Presenter providePresenter(UsedProductContract.Model model) {
        return new UsedProductPresenter(model);
    }

    @Singleton
    @Provides
    public UsedPoductRepository provideRepository(UsedProductApiService usedProductApiService, Context context) {
        return new UsedProductRepositoryIMPL(usedProductApiService, context);
    }


}
