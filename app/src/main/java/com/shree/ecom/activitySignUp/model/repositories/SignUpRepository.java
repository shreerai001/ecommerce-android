package com.shree.ecom.activitySignUp.model.repositories;

import com.shree.ecom.utils.values.AuthEntity;

import io.reactivex.Observable;

/**
 * Created by shree on 13,May,2019
 */
public interface SignUpRepository {
    Observable<AuthEntity> saveUsers(String firstName,
                                     String lastName,
                                     String phone,
                                     String email,
                                     String password,
                                     String passwordConfirmation);
}
