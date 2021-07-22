package com.shree.ecom.activityCancelOrders.module;

import android.content.Context;

import com.shree.ecom.activityCancelOrders.contract.CancelOrderContract;
import com.shree.ecom.activityCancelOrders.model.CancelOrderRepoisotry;
import com.shree.ecom.activityCancelOrders.model.CancelOrderRepositoryIMPL;
import com.shree.ecom.activityCancelOrders.presenter.CancelOrderPresenter;
import com.shree.ecom.activityCancelOrders.services.CancelOrderContractApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CancelOrderModule {

    @Provides
    public CancelOrderContract.Presenter providePresenter(CancelOrderRepoisotry cancelOrderModel) {
        return new CancelOrderPresenter(cancelOrderModel);
    }

    @Provides
    @Singleton
    public CancelOrderRepoisotry provideRepo(Context context, CancelOrderContractApiService cancelOrderContractApiService) {
        return new CancelOrderRepositoryIMPL(context, cancelOrderContractApiService);
    }
}
