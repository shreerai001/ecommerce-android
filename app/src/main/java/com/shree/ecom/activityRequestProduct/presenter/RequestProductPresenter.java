package com.shree.ecom.activityRequestProduct.presenter;

import android.content.Context;

import com.shree.ecom.activityRequestProduct.contract.RequestProductContract;
import com.shree.ecom.activityRequestProduct.model.dto.RequestProductEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RequestProductPresenter implements RequestProductContract.Presenter {

    private RequestProductContract.View view;
    private RequestProductContract.Model model;
    private Disposable disposable;

    public RequestProductPresenter(RequestProductContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(RequestProductContract.View view) {

    }

    @Override
    public void RequestProduct(Context context, RequestProductEntity requestProductEntity) {
        disposable = model
                .requestProduct(context, requestProductEntity)
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
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
