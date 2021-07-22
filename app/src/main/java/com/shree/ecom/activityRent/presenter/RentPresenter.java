package com.shree.ecom.activityRent.presenter;

import android.content.Context;

import com.shree.ecom.activityBrowse.model.repositories.rental.RentalRepository;
import com.shree.ecom.activityRent.contract.RentContract;
import com.shree.ecom.activityRent.model.dto.RentEntity;
import com.shree.ecom.activityRent.repositories.RentRepository;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RentPresenter implements RentContract.Presenter {

    private RentContract.View view;
    private RentRepository rentRepository;
    private Disposable disposable;


    public RentPresenter(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
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

    @Override
    public void setView(RentContract.View view) {
        this.view = view;
    }

    @Override
    public void rentProduct(Context context, RentEntity rentEntity) {
        disposable = rentRepository.rentProduct(context, rentEntity)
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
}
