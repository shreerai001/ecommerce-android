package com.shree.ecom.activityBrowse.contract;

import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductDto;
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalCartDto;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface AllProductContract {
    interface View extends BaseView {
        void loadData(List<AllEquipmentProductDto> equipmentEntityList);

        void addRentalCart(AllEquipmentProductEntity allEquipmentProductEntity);
    }

    interface Model {
        Observable<AllEquipmentProductEntity> getAllEquipmentList();

        boolean addAllProductToCart(AllEquipmentProductEntity allEquipmentProductEntity);
    }

    interface Presenter extends BasePresenter {
        void setView(AllProductContract.View view);

        void addAllProductToCart(AllEquipmentProductEntity allEquipmentProductEntity);
    }
}
