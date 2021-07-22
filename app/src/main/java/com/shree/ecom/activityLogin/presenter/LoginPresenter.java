package com.shree.ecom.activityLogin.presenter;

import android.widget.Toast;

import com.shree.ecom.activityLogin.contract.LoginContract;
import com.shree.ecom.activityLogin.model.dto.LoginResponseDto;
import com.shree.ecom.utils.values.CONST;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by shree on 14,May,2019
 */
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.Model model;
    private LoginContract.View view;
    private Disposable disposable;

    public LoginPresenter(LoginContract.Model model) {
        this.model = model;
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
    public void login(String email, String password) {
        if (view != null) {
            view.progressOn(true);
        }
        disposable = model.login(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<LoginResponseDto>() {
                    @Override
                    public void onNext(LoginResponseDto loginResponseDto) {
                        view.progressOn(false);
                        view.displayMessage(loginResponseDto.getData().getAccess_token());
                        if (loginResponseDto != null) {
                            if (model.saveToken(loginResponseDto.getData().getToken_type(), loginResponseDto.getData().getExpires_in()
                                    , loginResponseDto.getData().getAccess_token(), loginResponseDto.getData().getRefresh_token())) {
                                view.displayTransferMessage(CONST.SUCCED);
                            } else {
                                view.displayMessage(CONST.FAILED);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.displayMessage(e.getLocalizedMessage());
                        view.progressOn(false);
                    }

                    @Override
                    public void onComplete() {
                        view.loggedIn();
                    }
                });
    }

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
    }
}
