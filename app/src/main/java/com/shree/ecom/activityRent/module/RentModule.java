package com.shree.ecom.activityRent.module;

import com.shree.ecom.activityRent.contract.RentContract;
import com.shree.ecom.activityRent.model.RentModel;
import com.shree.ecom.activityRent.presenter.RentPresenter;
import com.shree.ecom.activityRent.repositories.RentRepository;
import com.shree.ecom.activityRent.repositories.RentRepositoryIMPL;
import com.shree.ecom.activityRent.services.RentApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RentModule {


    @Provides
    public RentContract.Presenter providesPresenter(RentRepository rentModel) {
        return new RentPresenter(rentModel);
    }
//
//    @Provides
//    public RentContract.Model providesModel(RentRepository rentalRepository) {
//        return new RentModel(rentalRepository);
//    }

    @Provides
    @Singleton
    public RentRepository providesRepo(RentApiService rentApiService) {
        return new RentRepositoryIMPL(rentApiService);
    }
}
