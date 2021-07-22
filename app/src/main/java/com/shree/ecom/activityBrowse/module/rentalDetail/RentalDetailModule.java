package com.shree.ecom.activityBrowse.module.rentalDetail;

import android.content.Context;

import com.shree.ecom.activityBrowse.contract.RentalDetailContract;
import com.shree.ecom.activityBrowse.model.RentalDetailModel;
import com.shree.ecom.activityBrowse.model.dto.rental.detail.RentalEquipmentDetailEntity;
import com.shree.ecom.activityBrowse.model.repositories.rental.RentalRepository;
import com.shree.ecom.activityBrowse.model.repositories.rental.RentalRepositoryIMPL;
import com.shree.ecom.activityBrowse.model.repositories.rentalDetail.RentalDetailRepository;
import com.shree.ecom.activityBrowse.presenter.RentalDetailPresenter;
import com.shree.ecom.activityBrowse.services.RentalApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;

@Module
public class RentalDetailModule {

    @Provides
    public RentalDetailContract.Model provideModel(RentalDetailRepository rentalDetailRepository) {
        return new RentalDetailModel(rentalDetailRepository);
    }

    @Provides
    public RentalDetailContract.Presenter providePresenter(RentalDetailContract.Model model) {
        return new RentalDetailPresenter(model);
    }

    @Provides
    @Singleton
    public RentalRepository provideRepository(Context context, RentalApiService rentalApiService) {
        return new RentalRepositoryIMPL(rentalApiService,context);
    }

}
