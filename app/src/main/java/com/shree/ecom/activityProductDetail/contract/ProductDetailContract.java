package com.shree.ecom.activityProductDetail.contract;

import com.shree.ecom.activityBrowse.model.dto.rental.RentalCartDto;
import com.shree.ecom.activityProductDetail.model.dto.ProductDetailEntity;
import com.shree.ecom.activityProductDetail.model.dto.ProductRecommendationDataDto;
import com.shree.ecom.activityProductDetail.model.dto.ProductRecommendationEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface ProductDetailContract {
    interface View extends BaseView {
        void loadProductRecommendataion(List<ProductRecommendationDataDto> productRecommendationDataDtoList);

        void addProductToCart(ProductDetailEntity productDetailEntity);

        void showLoading(boolean loadingState);

    }

    interface Presenter extends BasePresenter {
        void setView(ProductDetailContract.View view);

        void addProductToCart(ProductDetailEntity productDetailEntity);
    }

    interface Model {
        Observable<ProductRecommendationEntity> getProductRecommendation();

        boolean addProductToCart(ProductDetailEntity productDetailEntity);
    }
}
