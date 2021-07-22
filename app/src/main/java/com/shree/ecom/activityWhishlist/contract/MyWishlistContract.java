package com.shree.ecom.activityWhishlist.contract;

import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;
import com.shree.ecom.activityWhishlist.model.dto.WishlistDataEntity;
import com.shree.ecom.activityWhishlist.model.dto.WishlistEntity;

import java.util.List;

import io.reactivex.Observable;

public interface MyWishlistContract {
    interface View extends BaseView {
        void lodaData(List<WishlistDataEntity> wishlistDataEntityList);

    }

    interface Presenter extends BasePresenter {
        void loadData();

        void setView(MyWishlistContract.View view);

        boolean checkdLoggedIn();

    }

    interface Model {
        Observable<WishlistEntity> getWishList();

    }

}
