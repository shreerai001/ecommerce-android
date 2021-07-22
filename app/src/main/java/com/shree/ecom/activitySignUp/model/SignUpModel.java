package com.shree.ecom.activitySignUp.model;

import com.shree.ecom.activitySignUp.contract.SignUpContract;
import com.shree.ecom.activitySignUp.model.dto.SignUpDto;
import com.shree.ecom.utils.values.AuthEntity;
import com.shree.ecom.activitySignUp.model.repositories.SignUpRepository;

import java.util.List;

import io.reactivex.Observable;

public class SignUpModel implements SignUpContract.Model {

    private SignUpRepository signUpRepository;

    public SignUpModel(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }


    @Override
    public Observable<AuthEntity> saveUsers(String firstName, String lastName, String phone, String email, String password, String passwordConfirmation) {
        return signUpRepository.saveUsers(firstName, lastName, phone, email, password, passwordConfirmation);
    }

}
