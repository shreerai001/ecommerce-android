package com.shree.ecom.activitySignUp.contract;

import com.shree.ecom.activitySignUp.model.dto.SignUpDto;
import com.shree.ecom.utils.values.AuthEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface SignUpContract {
    interface View extends BaseView {

        void initView();

        void validate();

    }

    interface Presenter extends BasePresenter {
        void setView(SignUpContract.View view);

        void saveUsers(String firstName,
                       String lastName,
                       String phone,
                       String email,
                       String password,
                       String passwordConfirmation);

    }

    interface Model {

        Observable<AuthEntity> saveUsers(String firstName,
                                         String lastName,
                                         String phone,
                                         String email,
                                         String password,
                                         String passwordConfirmation);

    }
}
