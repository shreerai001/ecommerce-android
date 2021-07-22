package com.shree.ecom.activityLogin.model;

import com.shree.ecom.activityLogin.contract.LoginContract;
import com.shree.ecom.activityLogin.model.dto.LoginResponseDto;
import com.shree.ecom.activityLogin.model.repository.LoginRepository;

import io.reactivex.Observable;

/**
 * Created by shree on 14,May,2019
 */
public class LoginModel implements LoginContract.Model {

    private LoginRepository loginRepository;

    public LoginModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Observable<LoginResponseDto> login(String email, String password) {
        return loginRepository.login(email, password);
    }

    @Override
    public boolean saveToken(String tokenType, int expiresIn, String accessToken, String refreshToken) {
        if (loginRepository.saveToken(tokenType, expiresIn, accessToken, refreshToken)) ;
        return true;
    }
}
