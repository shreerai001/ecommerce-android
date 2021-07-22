package com.shree.ecom.activityWhishlist.contract;

import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface WishlistContract {
    interface View extends BaseView {
        void addToWishlist(String productId);


    }

    interface Presenter extends BasePresenter {
        void setView(WishlistContract.View view);

        void addToWishlist(String productId);


    }

    interface Model {
        Observable<BaseResponseEntity> addToWishlist(String productId);


    }


}
