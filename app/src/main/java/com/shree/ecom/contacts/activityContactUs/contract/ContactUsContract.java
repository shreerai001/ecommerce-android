package com.shree.ecom.contacts.activityContactUs.contract;

import com.shree.ecom.contacts.activityContactUs.model.dto.ContactUsResponseEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import io.reactivex.Observable;

/**
 * Created by shree on 16,May,2019
 */
public interface ContactUsContract {
    interface View extends BaseView {
        void saveQuery();
    }

    interface Presenter extends BasePresenter {
        void setView(ContactUsContract.View view);

        void saveQuery(String name, String email, String subject, String message);
    }

    interface Model {
        Observable<ContactUsResponseEntity> saveQuery(String name, String email, String subject, String message);
    }
}
