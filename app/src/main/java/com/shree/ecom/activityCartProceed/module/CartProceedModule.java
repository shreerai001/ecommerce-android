package com.shree.ecom.activityCartProceed.module;

import android.content.Context;

import com.shree.ecom.activityCartProceed.contract.CartProceedContract;
import com.shree.ecom.activityCartProceed.model.CartProceedModel;
import com.shree.ecom.activityCartProceed.presenter.CartPresenter;
import com.shree.ecom.activityCartProceed.repositories.CartProceedRepository;
import com.shree.ecom.activityCartProceed.repositories.CartProceedRepsitoryIMPL;
import com.shree.ecom.activityCartProceed.service.CartProceedApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CartProceedModule {

    @Provides
    public CartProceedContract.Presenter providesPresenter(CartProceedContract.Model model) {
        return new CartPresenter(model);
    }

    @Provides
    public CartProceedContract.Model providesModel(CartProceedRepository cartProceedRepository) {
        return new CartProceedModel(cartProceedRepository);
    }

    @Provides
    @Singleton
    public CartProceedRepository providesRepository(Context context, CartProceedApiService cartProceedApiService) {
        return new CartProceedRepsitoryIMPL(context, cartProceedApiService);
    }
}
