package com.shree.ecom.activitySignUp.model.repositories;

import com.shree.ecom.utils.values.AuthEntity;
import com.shree.ecom.activitySignUp.services.api.SignUpApiService;

import io.reactivex.Observable;

/**
 * Created by shree on 13,May,2019
 */
public class SignUpRepositoryIMPL implements SignUpRepository {

    private SignUpApiService signUpApiService;


    public SignUpRepositoryIMPL(SignUpApiService signUpApiService) {
        this.signUpApiService = signUpApiService;
    }

    @Override
    public Observable<AuthEntity> saveUsers(String firstName, String lastName, String phone, String email, String password, String passwordConfirmation) {
        return signUpApiService.signUP(firstName, lastName, phone, email, password, passwordConfirmation);
    }
}
