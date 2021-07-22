package com.shree.ecom.activityCartProceed.contract;

import com.shree.ecom.activityCartProceed.model.dto.CartProceedEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface CartProceedContract {
    interface View extends BaseView {

        void proceedCartEntity();

    }

    interface Presenter extends BasePresenter {
        void setView(CartProceedContract.View view);

        void proceedCartEntity(CartProceedEntity cartProceedEntity);
    }

    interface Model {
        Observable<BaseResponseEntity> proceedCartEntity(CartProceedEntity proceedEntity);
    }
}
