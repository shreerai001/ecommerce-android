package com.shree.ecom.activityBrowse.module.rental;

import android.content.Context;

import com.shree.ecom.activityBrowse.contract.RentalContract;
import com.shree.ecom.activityBrowse.model.rental.RentalModel;
import com.shree.ecom.activityBrowse.model.repositories.rental.RentalRepository;
import com.shree.ecom.activityBrowse.model.repositories.rental.RentalRepositoryIMPL;
import com.shree.ecom.activityBrowse.presenter.RentalPresenter;
import com.shree.ecom.activityBrowse.services.RentalApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RentalModule {

    @Provides
    public RentalContract.Presenter providePresenter(RentalContract.Model model) {
        return new RentalPresenter(model);
    }

    @Provides
    public RentalContract.Model provideModel(RentalRepository rentalRepository) {
        return new RentalModel(rentalRepository);
    }

    @Singleton
    @Provides
    public RentalRepository provideRepository(Context context, RentalApiService rentalApiService) {
        return new RentalRepositoryIMPL(rentalApiService, context);
    }
}
