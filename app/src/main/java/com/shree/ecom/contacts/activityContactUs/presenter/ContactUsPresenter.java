package com.shree.ecom.contacts.activityContactUs.presenter;

import com.shree.ecom.contacts.activityContactUs.contract.ContactUsContract;
import com.shree.ecom.contacts.activityContactUs.model.dto.ContactUsResponseEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by shree on 16,May,2019
 */
public class ContactUsPresenter implements ContactUsContract.Presenter {

    private ContactUsContract.View view;
    private ContactUsContract.Model model;
    private Disposable disposable;

    public ContactUsPresenter(ContactUsContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(ContactUsContract.View view) {
        this.view = view;
    }

    @Override
    public void saveQuery(String name, String email, String subject, String message) {
        disposable = model.saveQuery(name, email, subject, message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<ContactUsResponseEntity>() {
                            @Override
                            public void accept(ContactUsResponseEntity contactUsResponseEntity) throws Exception {
                                view.displayMessage(contactUsResponseEntity.getMsg());
                            }
                        }
                );
    }

    @Override
    public void loadData() {
    }

    @Override
    public void rxUnsuscribe() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
