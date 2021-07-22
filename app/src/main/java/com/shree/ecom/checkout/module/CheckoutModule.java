package com.shree.ecom.checkout.module;

import android.content.Context;

import com.shree.ecom.checkout.Repositories.CheckoutRepository;
import com.shree.ecom.checkout.Repositories.CheckoutRepositoryIMPL;
import com.shree.ecom.checkout.contract.CheckoutContract;
import com.shree.ecom.checkout.model.CheckoutModel;
import com.shree.ecom.checkout.presenter.CheckoutPresenter;
import com.shree.ecom.checkout.service.CheckoutService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CheckoutModule {
    @Provides
    public CheckoutContract.Model providesModel(CheckoutRepository checkoutRepository) {
        return new CheckoutModel(checkoutRepository);
    }

    @Provides
    public CheckoutContract.Presenter providePresenter(CheckoutContract.Model model, Context context) {
        return new CheckoutPresenter(model, context);
    }

    @Provides
    @Singleton
    public CheckoutRepository providesRepo(CheckoutService checkoutService, Context context) {
        return new CheckoutRepositoryIMPL(checkoutService, context);
    }
}
