package com.shree.ecom.logout.contract;

import android.content.Context;

import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

public interface LogOutContract {

    interface Presenter {
        void clearLogged(Context context);
    }

    interface Model {
        void clearLogged(Context context);
    }
}
