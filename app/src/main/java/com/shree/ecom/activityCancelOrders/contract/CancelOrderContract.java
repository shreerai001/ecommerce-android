package com.shree.ecom.activityCancelOrders.contract;

import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

public interface CancelOrderContract {
    interface View extends BaseView {
        void cancelOrder(String id);
    }

    interface Presenter extends BasePresenter {
        void cancelOrder(String id);

        void setView(CancelOrderContract.View view);
    }

}
