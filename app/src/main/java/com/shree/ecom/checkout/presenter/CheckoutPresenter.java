package com.shree.ecom.checkout.presenter;

import android.content.Context;

import com.shree.ecom.checkout.contract.CheckoutContract;
import com.shree.ecom.checkout.model.dto.CheckoutEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;
import com.shree.ecom.utils.values.NetworkUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CheckoutPresenter implements CheckoutContract.Presenter {

    private CheckoutContract.View view;
    private CheckoutContract.Model model;
    private Disposable disposable;
    private Context context;

    public CheckoutPresenter(CheckoutContract.Model model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public void addToCart(CheckoutEntity checkoutEntity) {
        if (NetworkUtils.isNetworkConnected(context)) {
            disposable = model.addToCart(checkoutEntity)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<BaseResponseEntity>() {
                        @Override
                        public void onNext(BaseResponseEntity baseResponseEntity) {
                            view.displayMessage(baseResponseEntity.getMsg());
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            view.displayMessage("Network not connected");
        }

    }

    @Override
    public void setView(CheckoutContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void rxUnsuscribe() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
