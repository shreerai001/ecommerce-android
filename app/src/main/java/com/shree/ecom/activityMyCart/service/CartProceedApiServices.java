package com.shree.ecom.activityMyCart.service;

import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface CartProceedApiServices {

    @POST("")
    Observable<BaseResponseEntity> proceedCart();
}
