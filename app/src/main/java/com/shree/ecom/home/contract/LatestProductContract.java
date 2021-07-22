package com.shree.ecom.home.contract;

import com.shree.ecom.home.model.dto.LatestProductEntity;
import com.shree.ecom.home.model.dto.ProductsEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface LatestProductContract {

    interface View extends BaseView {
        void updateData(List<ProductsEntity> productsList);

    }

    interface Presenter extends BasePresenter {


        void setView(LatestProductContract.View view);

    }

    interface Model {

        Observable<LatestProductEntity> getProduct();
    }

}
