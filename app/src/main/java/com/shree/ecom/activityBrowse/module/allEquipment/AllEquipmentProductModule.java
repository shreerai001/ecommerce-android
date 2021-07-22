package com.shree.ecom.activityBrowse.module.allEquipment;

import android.content.Context;

import com.shree.ecom.activityBrowse.contract.AllProductContract;
import com.shree.ecom.activityBrowse.model.AllEquipmentProductModel;
import com.shree.ecom.activityBrowse.model.repositories.all.AllEquipmentProductRepository;
import com.shree.ecom.activityBrowse.model.repositories.all.AllEquipmentProductRepositoryIMPL;
import com.shree.ecom.activityBrowse.presenter.AllEquipmentProductPresenter;
import com.shree.ecom.activityBrowse.services.AllEquipmentApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AllEquipmentProductModule {

    @Provides
    public AllProductContract.Model provideModle(AllEquipmentProductRepository allEquipmentProductRepository) {
        return new AllEquipmentProductModel(allEquipmentProductRepository);
    }

    @Provides
    public AllProductContract.Presenter providePresenter(AllProductContract.Model model, Context context) {
        return new AllEquipmentProductPresenter(model, context);
    }

    @Singleton
    @Provides
    public AllEquipmentProductRepository provideRepository(Context context, AllEquipmentApiService allEquipmentApiService) {
        return new AllEquipmentProductRepositoryIMPL(context, allEquipmentApiService);
    }


}
