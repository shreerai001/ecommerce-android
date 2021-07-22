package com.shree.ecom.activityMyOrders.contract;

import com.shree.ecom.activityMyOrders.model.dto.MyOrdersDataEntity;
import com.shree.ecom.activityMyOrders.model.dto.MyOrdersEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface MyOrdersContract {
    interface View extends BaseView {
        void loadData(List<MyOrdersDataEntity> myOrdersDataEntityList);
    }

    interface Model {
        Observable<MyOrdersEntity> getMyOrders();
    }

    interface Presenter extends BasePresenter {
        void setView(MyOrdersContract.View view);
    }
}
