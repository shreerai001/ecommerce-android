package com.shree.ecom.activityRequestProduct.module;

import com.shree.ecom.activityRequestProduct.contract.RequestProductContract;
import com.shree.ecom.activityRequestProduct.model.RequestProductModel;
import com.shree.ecom.activityRequestProduct.model.repositories.RequestProductRepository;
import com.shree.ecom.activityRequestProduct.model.repositories.RequestProductRepositoryIMPL;
import com.shree.ecom.activityRequestProduct.presenter.RequestProductPresenter;
import com.shree.ecom.activityRequestProduct.service.RequestProductApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RequestProductModule {

    @Provides
    public RequestProductContract.Presenter providesPresenter(RequestProductContract.Model model) {
        return new RequestProductPresenter(model);
    }

    @Provides
    public RequestProductContract.Model providesModel(RequestProductRepository requestProductRepository) {
        return new RequestProductModel(requestProductRepository);
    }

    @Provides
    @Singleton
    public RequestProductRepository providesRepo(RequestProductApiService requestProductApiService) {
        return new RequestProductRepositoryIMPL(requestProductApiService);
    }
}
