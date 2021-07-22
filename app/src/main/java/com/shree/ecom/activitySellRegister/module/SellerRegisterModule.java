package com.shree.ecom.activitySellRegister.module;

import android.content.Context;

import com.shree.ecom.activitySellRegister.contract.RegisterSellerContract;
import com.shree.ecom.activitySellRegister.model.RegisterSellModel;
import com.shree.ecom.activitySellRegister.model.repository.RegisterSellRepository;
import com.shree.ecom.activitySellRegister.model.repository.RegisterSellRepositoryIMPL;
import com.shree.ecom.activitySellRegister.presenter.RegisterSellPresenter;
import com.shree.ecom.activitySellRegister.service.RegisterSellApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SellerRegisterModule {
    @Provides
    public RegisterSellerContract.Presenter providesPresenter(RegisterSellerContract.Model model) {
        return new RegisterSellPresenter(model);
    }

    @Provides
    public RegisterSellerContract.Model providesModel(RegisterSellRepository registerSellRepository) {
        return new RegisterSellModel(registerSellRepository);
    }

    @Provides
    @Singleton
    public RegisterSellRepository providesRepository(Context context, RegisterSellApiService registerSellApiService) {
        return new RegisterSellRepositoryIMPL(context, registerSellApiService);
    }
}
