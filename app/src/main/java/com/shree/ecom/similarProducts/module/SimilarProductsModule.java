package com.shree.ecom.similarProducts.module;

import android.content.Context;

import com.shree.ecom.similarProducts.contract.SimilarProductsContract;
import com.shree.ecom.similarProducts.model.SimilarProductsModel;
import com.shree.ecom.similarProducts.model.repositories.SimilarProductsRepository;
import com.shree.ecom.similarProducts.model.repositories.SimilarProductsRepositoryIMPL;
import com.shree.ecom.similarProducts.presenter.SimilarProductsPresenter;
import com.shree.ecom.similarProducts.service.SimilarProductsApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SimilarProductsModule {
    @Provides
    public SimilarProductsContract.Model providesModel(SimilarProductsRepository similarProductsRepository) {
        return new SimilarProductsModel(similarProductsRepository);
    }

    @Provides
    public SimilarProductsContract.Presenter providesPresenter(SimilarProductsContract.Model model, Context context) {
        return new SimilarProductsPresenter(model, context);
    }

    @Provides
    @Singleton
    public SimilarProductsRepository provideRepository(Context context, SimilarProductsApiService similarProductsApiService) {
        return new SimilarProductsRepositoryIMPL(context, similarProductsApiService);
    }
}
