package com.shree.ecom.activityLogin.model.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.shree.ecom.activityLogin.model.dto.LoginResponseDto;
import com.shree.ecom.activityLogin.services.LoginApiServices;

import io.reactivex.Observable;

/**
 * Created by shree on 14,May,2019
 */
public class LoginRepositoryIMPL implements LoginRepository {

    private LoginApiServices loginApiServices;
    private Context context_dco;

    public LoginRepositoryIMPL(Context context, LoginApiServices loginApiServices) {
        this.context_dco = context;
        this.loginApiServices = loginApiServices;
    }

    @Override
    public Observable<LoginResponseDto> login(String email, String password) {
        return loginApiServices.login(email, password);
    }

    @Override
    public boolean saveToken(String tokenType, int expiresIn, String accessToken, String refreshToken) {
        try {
            SharedPreferences sharedPreferences = context_dco.getSharedPreferences("Token", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("tokenType", tokenType);
            editor.putInt("expiresIn", expiresIn);
            editor.putString("accessToken", accessToken);
            editor.putString("refreshToken", refreshToken);
            editor.putBoolean("loggedIn", true);
            editor.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
