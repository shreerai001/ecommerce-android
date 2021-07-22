package com.shree.ecom.contacts.activityPolicy.contract;

import com.shree.ecom.contacts.activityPolicy.model.dto.PolicyEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by shree on 16,May,2019
 */
public interface PolicyContract {
    interface View extends BaseView {

        void updateView(List<PolicyEntity> policyEntityList);
    }

    interface Presenter extends BasePresenter {
        void setView(PolicyContract.View view);

    }

    interface Model {
        Observable<PolicyEntity> getPolicy();
    }
}
