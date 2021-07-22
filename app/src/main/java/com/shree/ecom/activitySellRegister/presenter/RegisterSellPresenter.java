package com.shree.ecom.activitySellRegister.presenter;

import android.util.Log;

import com.shree.ecom.activitySellRegister.contract.RegisterSellerContract;
import com.shree.ecom.activitySellRegister.model.dto.RegisterSellResponseDto;
import com.shree.ecom.activitySellRegister.model.dto.RegisterSellerEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RegisterSellPresenter implements RegisterSellerContract.Presenter {

    private RegisterSellerContract.View view;
    private RegisterSellerContract.Model model;
    private Disposable disposable;

    public RegisterSellPresenter(RegisterSellerContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(RegisterSellerContract.View view) {
        this.view = view;
    }

    @Override
    public void regiseterSeller(final RegisterSellerEntity registerSellerEntity) {
        model.registerSeller(registerSellerEntity)
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
//                .subscribeWith(new DisposableObserver<BaseResponseEntity>() {
//                    @Override
//                    public void onNext(RegisterSellResponseDto registerSellResponseDto) {
//                        view.displayMessage(registerSellResponseDto.getSucess());
//                        Log.d("SUCCESS", "TRUE");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("SUCCESS", "False" + e.getLocalizedMessage());
//                   //     view.displayMessage(e.getLocalizedMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d("SUCCESS", "OnComplete");
//
//                    }
//                });
    }

    @Override
    public void loadData() {
    }

    @Override
    public void rxUnsuscribe() {

    }
}
