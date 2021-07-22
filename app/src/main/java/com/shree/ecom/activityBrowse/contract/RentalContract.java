package com.shree.ecom.activityBrowse.contract;

import com.shree.ecom.activityBrowse.model.dto.rental.RentalCartDto;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalDataDto;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalEquipmentEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface RentalContract {
    interface View extends BaseView {
        void loadData(List<RentalDataDto> rentalDataDtoList);

        void addRentalCart(RentalCartDto rentalCartDto);
    }

    interface Presenter extends BasePresenter {
        void setView(RentalContract.View view);

        void addRentalCart(RentalCartDto rentalCartDto);
    }

    interface Model {
        Observable<RentalEquipmentEntity> getRentalEntity();

        boolean saveRentalCart(RentalCartDto rentalCartDto);
    }
}
