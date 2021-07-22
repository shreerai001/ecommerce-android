package com.shree.ecom.activityMain.contract;

import com.shree.ecom.activityProfile.model.dto.ProfileDataDto;
import com.shree.ecom.activityProfile.model.dto.ProfileEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import io.reactivex.Observable;

public interface ActivityMainContract {
    interface View extends BaseView {
        void initView(android.view.View view);

        void loadFragment();

        void loadProfileIfLogged(ProfileDataDto profileEntity);


    }

    interface Model {
        boolean checkedLogged();
    }

    interface Presenter extends BasePresenter {

        void setView(ActivityMainContract.View view);

        boolean checkedLogged();

        void saveProfileDetail();

    }
}
