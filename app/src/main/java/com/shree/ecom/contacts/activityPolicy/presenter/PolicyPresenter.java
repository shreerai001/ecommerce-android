package com.shree.ecom.contacts.activityPolicy.presenter;

import com.shree.ecom.contacts.activityPolicy.contract.PolicyContract;
import com.shree.ecom.contacts.activityPolicy.model.dto.PolicyEntity;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by shree on 16,May,2019
 */
public class PolicyPresenter implements PolicyContract.Presenter {

    private PolicyContract.View view;
    private PolicyContract.Model model;
    private Disposable disposable;

    public PolicyPresenter(PolicyContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(PolicyContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        disposable = model
                .getPolicy()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<PolicyEntity>() {
                            @Override
                            public void accept(PolicyEntity policyEntity) throws Exception {
                                if (view != null) {
                                    List<PolicyEntity> policyEntityList = new ArrayList<>();
                                    policyEntityList.add(policyEntity);
                                    view.updateView(policyEntityList);
                                } else {
                                    view.displayMessage(CONST.NETWORK_FETCH_ERROR);
                                }
                            }
                        }
                );
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
