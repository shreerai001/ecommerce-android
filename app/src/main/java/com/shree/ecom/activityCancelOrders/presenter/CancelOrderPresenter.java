package com.shree.ecom.activityCancelOrders.presenter;

import com.shree.ecom.activityCancelOrders.contract.CancelOrderContract;
import com.shree.ecom.activityCancelOrders.model.CancelOrderRepoisotry;
import com.shree.ecom.utils.values.BaseResponseEntity;
import com.shree.ecom.utils.values.CONST;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CancelOrderPresenter implements CancelOrderContract.Presenter {
    private CancelOrderContract.View view;
    private CancelOrderRepoisotry model;
    private Disposable disposable;

    public CancelOrderPresenter(CancelOrderRepoisotry model) {
        this.model = model;
    }

    @Override
    public void cancelOrder(String id) {
        disposable = model
                .cancelOrder(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<BaseResponseEntity>() {
                            @Override
                            public void accept(BaseResponseEntity baseResponseEntity) throws Exception {
                                if (view != null) {
                                    view.displayMessage(baseResponseEntity.getMsg());
                                } else {
                                    view.displayMessage(CONST.NETWORK_FETCH_ERROR);
                                }
                            }
                        }
                );
    }

    @Override
    public void setView(CancelOrderContract.View view) {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void rxUnsuscribe() {

    }
}
