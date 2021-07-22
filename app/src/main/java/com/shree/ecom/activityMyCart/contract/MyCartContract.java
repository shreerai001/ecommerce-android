package com.shree.ecom.activityMyCart.contract;

import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;
import com.shree.ecom.utils.values.CartEntity;

import java.util.List;

public interface MyCartContract {
    interface View extends BaseView {
        void loadData(List<CartEntity> cartEntities);

        void deleteFromCart(int id);
    }

    interface Presenter extends BasePresenter {
        void setView(MyCartContract.View view);

        void deleteFromCart(int id);

        boolean checkLoggedIn();
    }

    interface Model {
        List<CartEntity> getCartDetail();

        List<CartEntity> deleteFromCart(int id);

    }
}
