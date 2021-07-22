package com.shree.ecom.activityRequestProduct.contract;

import android.content.Context;

import com.shree.ecom.activityRequestProduct.model.dto.RequestProductEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface RequestProductContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter {
        void setView(RequestProductContract.View view);

        void RequestProduct(Context context, RequestProductEntity requestProductEntity);
    }

    interface Model {
        Observable<BaseResponseEntity> requestProduct(Context context, RequestProductEntity requestProductEntity);
    }
}
