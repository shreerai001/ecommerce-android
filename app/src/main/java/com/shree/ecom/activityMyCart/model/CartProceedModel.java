package com.shree.ecom.activityMyCart.model;

import com.shree.ecom.activityMyCart.contract.CartProceedContract;
import com.shree.ecom.activityMyCart.model.dto.CartProceedEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class CartProceedModel implements CartProceedContract.Model {
    @Override
    public Observable<BaseResponseEntity> proceedCart(CartProceedEntity cartProceedEntity) {
        return null;
    }
}
