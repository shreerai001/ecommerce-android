package com.shree.ecom.home.module;

import android.content.Context;

import com.shree.ecom.home.contract.LatestProductContract;
import com.shree.ecom.home.model.LatestProductModel;
import com.shree.ecom.home.model.repository.product.LatestProductRepository;
import com.shree.ecom.home.model.repository.product.LatestProductRepositoryIMPL;
import com.shree.ecom.home.presenter.LatestProductPresenter;
import com.shree.ecom.home.services.LatestProductApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LatestProductModule {
    @Provides
    public LatestProductContract.Presenter provideProductPresenter(LatestProductContract.Model model) {
        return new LatestProductPresenter(model);
    }

    @Provides
    public LatestProductContract.Model provideProductModuleModel(LatestProductRepository productRepository) {
        return new LatestProductModel(productRepository);
    }

    @Singleton
    @Provides
    public LatestProductRepository provideRepo(Context context, LatestProductApiService productApiService) {
        return new LatestProductRepositoryIMPL(context, productApiService);
    }

}
