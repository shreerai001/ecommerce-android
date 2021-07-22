package com.shree.ecom.activityBrowse.contract;

import com.shree.ecom.activityBrowse.model.dto.rental.detail.RentalDetailDataDto;
import com.shree.ecom.activityBrowse.model.dto.rental.detail.RentalEquipmentDetailEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface RentalDetailContract {
    interface View extends BaseView {
        void loadData(List<RentalDetailDataDto> rentalDetailDataDtoList);

        void initView();
    }

    interface Presenter extends BasePresenter {
        void setView(RentalDetailContract.View view);

    }

    interface Model {
        Observable<RentalEquipmentDetailEntity> getRentalDetail();
    }
}
