package com.shree.ecom.activityMyCart.module;

import android.content.Context;

import com.shree.ecom.activityMyCart.contract.MyCartContract;
import com.shree.ecom.activityMyCart.model.MyCartModel;
import com.shree.ecom.activityMyCart.presenter.MyCartPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MyCartModule {

    @Provides
    public MyCartContract.Model providesMycartModel(Context context) {
        return new MyCartModel(context);
    }

    @Provides
    public MyCartContract.Presenter provideMyCarPresenter(Context context, MyCartContract.Model model) {
        return new MyCartPresenter(context, model);
    }
}
