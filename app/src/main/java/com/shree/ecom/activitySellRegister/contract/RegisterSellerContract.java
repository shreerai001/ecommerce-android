package com.shree.ecom.activitySellRegister.contract;

import com.shree.ecom.activitySellRegister.model.dto.RegisterSellResponseDto;
import com.shree.ecom.activitySellRegister.model.dto.RegisterSellerEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface RegisterSellerContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter {
        void setView(RegisterSellerContract.View view);

        void regiseterSeller(RegisterSellerEntity registerSellerEntity);
    }

    interface Model {
        Observable<BaseResponseEntity> registerSeller(RegisterSellerEntity registerSellerEntity);
    }
}
