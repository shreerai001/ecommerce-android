package com.shree.ecom.categories.contract;

import com.shree.ecom.categories.model.dto.equipment.EquipmentDto;
import com.shree.ecom.categories.model.dto.equipment.EquipmentEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface EquipmentContract {
    interface View extends BaseView {
        void updateData(List<EquipmentDto> equipmentEntityList);
    }

    interface Presenter extends BasePresenter {
        void setView(EquipmentContract.View view);
    }

    interface Model {
        Observable<EquipmentEntity> getEquipmentData();
    }
}
