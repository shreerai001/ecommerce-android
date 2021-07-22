package com.shree.ecom.activityMyCart.contract;

import com.shree.ecom.activityMyCart.model.dto.CartProceedEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface CartProceedContract {

    interface View {
    }

    interface Presenter {
        void setView(CartProceedContract.View view);

        Observable<BaseResponseEntity> proceedCart(CartProceedEntity cartProceedEntity);
    }

    interface Model {
        Observable<BaseResponseEntity> proceedCart(CartProceedEntity cartProceedEntity);
    }
}
