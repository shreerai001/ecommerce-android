package com.shree.ecom.activityMyCart.model.repositories;

import com.shree.ecom.activityMyCart.model.dto.CartProceedEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface CartProceedRepository {
    Observable<BaseResponseEntity> proceedCart(CartProceedEntity cartProceedEntity);
}
