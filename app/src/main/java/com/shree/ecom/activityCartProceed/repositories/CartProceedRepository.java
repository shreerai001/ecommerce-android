package com.shree.ecom.activityCartProceed.repositories;

import com.shree.ecom.activityCartProceed.model.dto.CartProceedEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface CartProceedRepository {
    Observable<BaseResponseEntity> proceedCart(CartProceedEntity cartProceedEntity);
}
