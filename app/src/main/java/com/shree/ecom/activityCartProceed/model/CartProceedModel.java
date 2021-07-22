package com.shree.ecom.activityCartProceed.model;

import com.shree.ecom.activityCartProceed.contract.CartProceedContract;
import com.shree.ecom.activityCartProceed.model.dto.CartProceedEntity;
import com.shree.ecom.activityCartProceed.repositories.CartProceedRepository;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class CartProceedModel implements CartProceedContract.Model {
    private CartProceedRepository cartProceedRepository;

    public CartProceedModel(CartProceedRepository cartProceedRepository) {
        this.cartProceedRepository = cartProceedRepository;
    }

    @Override
    public Observable<BaseResponseEntity> proceedCartEntity(CartProceedEntity proceedEntity) {
        return cartProceedRepository.proceedCart(proceedEntity);
    }
}
