package com.shree.ecom.similarProducts.contract;

import com.shree.ecom.similarProducts.model.dto.SimilarProductsEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface SimilarProductsContract {
    interface View extends BaseView {
        void loadSimilarProducts(List<SimilarProductsEntity> similarProductsEntityList);
    }

    interface Presenter extends BasePresenter {
        void setView(SimilarProductsContract.View view);

        void loadSimilarProducts(String id);
    }

    interface Model {
        Observable<List<SimilarProductsEntity>> getSimilarProducts(String id);
    }
}
