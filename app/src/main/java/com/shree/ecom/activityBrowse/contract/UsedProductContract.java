package com.shree.ecom.activityBrowse.contract;

import com.shree.ecom.activityBrowse.model.dto.used.UsedProductDataDto;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface UsedProductContract {
    interface View extends BaseView {
        void loadData(List<UsedProductDataDto> newProductDataDtoList);
    }

    interface Model {
        Observable<UsedProductEntity> getProductsEntity();
    }

    interface Presenter extends BasePresenter {
        void setView(UsedProductContract.View view);
    }
}
