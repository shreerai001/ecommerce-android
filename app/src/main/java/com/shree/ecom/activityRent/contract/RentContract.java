package com.shree.ecom.activityRent.contract;

import android.content.Context;

import com.shree.ecom.activityRent.model.dto.RentEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface RentContract {
    interface View extends BaseView {
    }

    interface Model {
        Observable<BaseResponseEntity> rentProduct(Context context, RentEntity rentEntity);
    }

    interface Presenter extends BasePresenter {
        void setView(RentContract.View view);

        void rentProduct(Context context, RentEntity rentEntity);
    }
}
