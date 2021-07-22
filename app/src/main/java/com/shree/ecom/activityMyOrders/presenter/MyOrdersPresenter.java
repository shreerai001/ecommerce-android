package com.shree.ecom.activityMyOrders.presenter;

import com.shree.ecom.activityMyOrders.contract.MyOrdersContract;
import com.shree.ecom.activityMyOrders.model.dto.MyOrdersDataEntity;
import com.shree.ecom.activityMyOrders.model.dto.MyOrdersEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MyOrdersPresenter implements MyOrdersContract.Presenter {
    private MyOrdersContract.View view;
    private MyOrdersContract.Model model;
    private Disposable disposable;

    public MyOrdersPresenter(MyOrdersContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(MyOrdersContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        disposable = model.getMyOrders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<MyOrdersEntity>() {
                            @Override
                            public void accept(MyOrdersEntity myOrdersEntity) throws Exception {
                                if (view != null) {
                                    List<MyOrdersDataEntity> myOrdersDataEntityList = new ArrayList<>();
                                    for (int i = 0; i < myOrdersEntity.getData().size(); i++) {
                                        myOrdersDataEntityList.add(myOrdersEntity.getData().get(i));
                                    }
                                    view.loadData(myOrdersDataEntityList);
                                } else {

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
