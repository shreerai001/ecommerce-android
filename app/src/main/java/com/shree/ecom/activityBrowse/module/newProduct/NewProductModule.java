package com.shree.ecom.activityBrowse.module.newProduct;

import android.content.Context;

import com.shree.ecom.activityBrowse.contract.AllProductContract;
import com.shree.ecom.activityBrowse.contract.NewProductContract;
import com.shree.ecom.activityBrowse.model.AllEquipmentProductModel;
import com.shree.ecom.activityBrowse.model.NewProductModel;
import com.shree.ecom.activityBrowse.model.repositories.all.AllEquipmentProductRepository;
import com.shree.ecom.activityBrowse.model.repositories.all.AllEquipmentProductRepositoryIMPL;
import com.shree.ecom.activityBrowse.model.repositories.newProduct.NewProductRepository;
import com.shree.ecom.activityBrowse.model.repositories.newProduct.NewProductRepositoryIMPL;
import com.shree.ecom.activityBrowse.presenter.AllEquipmentProductPresenter;
import com.shree.ecom.activityBrowse.presenter.NewProductPresenter;
import com.shree.ecom.activityBrowse.services.AllEquipmentApiService;
import com.shree.ecom.activityBrowse.services.NewProductApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NewProductModule {

    @Provides
    public NewProductContract.Model provideModle(NewProductRepository newProductRepository) {
        return new NewProductModel(newProductRepository);
    }

    @Provides
    public NewProductContract.Presenter providePresenter(NewProductContract.Model model) {
        return new NewProductPresenter(model);
    }

    @Singleton
    @Provides
    public NewProductRepository provideRepository(Context context, NewProductApiService newProductApiService) {
        return new NewProductRepositoryIMPL(context, newProductApiService);
    }


}
