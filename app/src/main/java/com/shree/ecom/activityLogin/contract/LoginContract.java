package com.shree.ecom.activityLogin.contract;

import com.shree.ecom.activityLogin.model.dto.LoginResponseDto;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import io.reactivex.Observable;

/**
 * Created by shree on 14,May,2019
 */
public interface LoginContract {
    interface View extends BaseView {

        void login();

        void signUp();

        void loggedIn();

    }

    interface Presenter extends BasePresenter {
        void login(String email, String password);

        void setView(LoginContract.View view);
    }

    interface Model {
        Observable<LoginResponseDto> login(String email, String password);

        boolean saveToken(String tokenType, int expiresIn, String accessToken, String refreshToken);
    }
}
