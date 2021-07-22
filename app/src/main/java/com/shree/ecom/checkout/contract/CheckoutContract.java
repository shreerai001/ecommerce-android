package com.shree.ecom.checkout.contract;

import com.shree.ecom.activityBrowse.model.dto.PersonalCartDto;
import com.shree.ecom.checkout.model.dto.Cart;
import com.shree.ecom.checkout.model.dto.CheckoutEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface CheckoutContract {
    interface View extends BaseView {
        void addToCart(Cart cart);
    }

    interface Presenter extends BasePresenter {
        void addToCart(CheckoutEntity checkoutEntity);

        void setView(CheckoutContract.View view);
    }

    interface Model {
        Observable<BaseResponseEntity> addToCart(CheckoutEntity checkoutEntity);

        PersonalCartDto getPersonalDetail();
    }
}
