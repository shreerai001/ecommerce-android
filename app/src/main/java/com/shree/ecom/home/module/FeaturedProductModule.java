package com.shree.ecom.home.module;

import android.content.Context;

import com.shree.ecom.home.contract.FeaturedProductContract;
import com.shree.ecom.home.contract.LatestProductContract;
import com.shree.ecom.home.model.FeaturedProductModel;
import com.shree.ecom.home.model.LatestProductModel;
import com.shree.ecom.home.model.repository.product.FeaturedProductRepository;
import com.shree.ecom.home.model.repository.product.FeaturedProductRepositoryIMPL;
import com.shree.ecom.home.model.repository.product.LatestProductRepository;
import com.shree.ecom.home.model.repository.product.LatestProductRepositoryIMPL;
import com.shree.ecom.home.presenter.FeaturedProductPresenter;
import com.shree.ecom.home.presenter.LatestProductPresenter;
import com.shree.ecom.home.services.FeaturedProductApiService;
import com.shree.ecom.home.services.LatestProductApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FeaturedProductModule {
    @Provides
    public FeaturedProductContract.Presenter provideProductPresenter(FeaturedProductContract.Model model) {
        return new FeaturedProductPresenter(model);
    }

    @Provides
    public FeaturedProductContract.Model provideProductModuleModel(FeaturedProductRepository productRepository) {
        return new FeaturedProductModel(productRepository);
    }

    @Singleton
    @Provides
    public FeaturedProductRepository provideRepo(Context context, FeaturedProductApiService productApiService) {
        return new FeaturedProductRepositoryIMPL(context, productApiService);
    }

}
