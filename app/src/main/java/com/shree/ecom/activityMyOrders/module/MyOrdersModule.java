package com.shree.ecom.activityMyOrders.module;

import android.content.Context;

import com.shree.ecom.activityMyOrders.contract.MyOrdersContract;
import com.shree.ecom.activityMyOrders.model.MyOrderModel;
import com.shree.ecom.activityMyOrders.model.repositories.MyOrdersRepository;
import com.shree.ecom.activityMyOrders.model.repositories.MyOrdersRepositoryIMPL;
import com.shree.ecom.activityMyOrders.presenter.MyOrdersPresenter;
import com.shree.ecom.activityMyOrders.services.MyOrdersApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyOrdersModule {
    @Provides
    public MyOrdersContract.Presenter providePresenter(MyOrdersContract.Model model) {
        return new MyOrdersPresenter(model);
    }

    @Provides
    public MyOrdersContract.Model provideModel(MyOrdersRepository myOrdersRepository) {
        return new MyOrderModel(myOrdersRepository);
    }

    @Provides
    @Singleton
    public MyOrdersRepository provideApiService(Context context, MyOrdersApiService myOrdersApiService) {
        return new MyOrdersRepositoryIMPL(context, myOrdersApiService);
    }
}
