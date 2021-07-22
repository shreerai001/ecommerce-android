package com.shree.ecom.activityProfile.contract;

import android.content.Context;

import com.shree.ecom.activityProfile.model.dto.ProfileDataDto;
import com.shree.ecom.activityProfile.model.dto.ProfileEntity;
import com.shree.ecom.activityProfile.model.dto.ProfileShippingDataDto;
import com.shree.ecom.activityProfile.model.dto.ShippingEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import io.reactivex.Observable;

public interface ProfileContract {
    interface View extends BaseView {
        void loadShippingDetail(ProfileShippingDataDto shippingEntity);

        void loadPresonalDetail(ProfileDataDto profileEntity);
    }

    interface Presenter extends BasePresenter {
        void setView(ProfileContract.View view);
    }

    interface Model {
        Observable<ProfileEntity> getProfileDetail();

        Observable<ShippingEntity> getShippingDetail();

        void insertProfileDetail(Context context, ProfileDataDto profileDataDto);
    }
}
