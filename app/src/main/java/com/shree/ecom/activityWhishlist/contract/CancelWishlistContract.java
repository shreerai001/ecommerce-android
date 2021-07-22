package com.shree.ecom.activityWhishlist.contract;

import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface CancelWishlistContract {
    interface View extends BaseView {
        void cancelWishList(String productId);


    }

    interface Presenter extends BasePresenter {
        void setView(CancelWishlistContract.View view);

        void cancelWishList(String productId);


    }

    interface Model {
        Observable<BaseResponseEntity> cancelWishtlist(String productId);


    }


}
