package com.shree.ecom.activityCartProceed.presenter;

import com.shree.ecom.activityCartProceed.contract.CartProceedContract;
import com.shree.ecom.activityCartProceed.model.dto.CartProceedEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CartPresenter implements CartProceedContract.Presenter {

    private CartProceedContract.View view;
    private CartProceedContract.Model model;
    private Disposable disposable;

    public CartPresenter(CartProceedContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(CartProceedContract.View view) {
        this.view = view;
    }

    @Override
    public void proceedCartEntity(CartProceedEntity cartProceedEntity) {
        disposable = model.proceedCartEntity(cartProceedEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<BaseResponseEntity>() {
                    @Override
                    public void onNext(BaseResponseEntity baseResponseEntity) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void loadData() {

    }

    @Override
    public void rxUnsuscribe() {

    }
}
