package com.shree.ecom.activityBrowse.contract;

import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductDataDto;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductsEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface NewProductContract {
    interface View extends BaseView {
        void loadData(List<NewProductDataDto> newProductDataDtoList);
    }

    interface Model {
        Observable<NewProductsEntity> getProductsEntity();
    }

    interface Presenter extends BasePresenter {
        void setView(NewProductContract.View view);
    }
}
