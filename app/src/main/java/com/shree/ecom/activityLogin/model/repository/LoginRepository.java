package com.shree.ecom.activityLogin.model.repository;

import com.shree.ecom.activityLogin.model.dto.LoginResponseDto;

import io.reactivex.Observable;

/**
 * Created by shree on 14,May,2019
 */
public interface LoginRepository {
    Observable<LoginResponseDto> login(String email, String password);

    boolean saveToken(String tokenType, int expiresIn, String accessToken, String refreshToken);
}
