package com.shree.ecom.home.contract;

import com.shree.ecom.home.model.dto.FeaturedProductDto;
import com.shree.ecom.home.model.dto.FeaturedProductEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface FeaturedProductContract {

    interface View extends BaseView {
        void updateFeaturedData(List<FeaturedProductDto> productsList);

        void offlineActivity();

        void showLoading(boolean isLoading);

    }

    interface Presenter extends BasePresenter {


        void setView(FeaturedProductContract.View view);

    }

    interface Model {

        Observable<FeaturedProductEntity> getFeaturedProduct();
    }

}
