package com.shree.ecom.activitySignUp.presenter;

import com.shree.ecom.activitySignUp.contract.SignUpContract;
import com.shree.ecom.utils.values.AuthEntity;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SignUpPresenter implements SignUpContract.Presenter {

    private SignUpContract.View view;
    private SignUpContract.Model model;
    private Disposable disposable;


    public SignUpPresenter(SignUpContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(SignUpContract.View view) {
        this.view = view;
    }

    @Override
    public void saveUsers(String firstName,
                          String lastName,
                          String phone,
                          String email,
                          String password,
                          String passwordConfirmation) {
        disposable = model
                .saveUsers(firstName, lastName, phone, email, password, passwordConfirmation)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<AuthEntity>() {
                            @Override
                            public void accept(AuthEntity authEntity) throws Exception {

                            }
                        }
                );
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
