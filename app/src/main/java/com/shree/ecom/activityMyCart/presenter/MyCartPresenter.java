package com.shree.ecom.activityMyCart.presenter;

import android.content.Context;

import com.shree.ecom.activityMyCart.contract.MyCartContract;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;
import com.shree.ecom.utils.values.CartEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MyCartPresenter extends BaseRepositoryIMPL implements MyCartContract.Presenter {
    private MyCartContract.View view;
    private MyCartContract.Model model;
    private Disposable disposable;

    public MyCartPresenter(Context context, MyCartContract.Model model) {
        super(context);
        this.model = model;
    }

    @Override
    public void setView(MyCartContract.View view) {
        this.view = view;
    }

    @Override
    public void deleteFromCart(int id) {
        model.deleteFromCart(id);
//        disposable = Observable.fromArray(model.deleteFromCart(id))
//                .subscribe(
//                        new Consumer<List<CartEntity>>() {
//                            @Override
//                            public void accept(List<CartEntity> cartEntities) throws Exception {
//                                view.loadData(cartEntities);
//                            }
//                        }
//                );
    }

    @Override
    public boolean checkLoggedIn() {
        return super.checkdLoggedIn();
    }

    @Override
    public void loadData() {
//        disposable = Observable.fromArray(model.getCartDetail())
//                .subscribe(
//                        new Consumer<List<CartEntity>>() {
//                            @Override
//                            public void accept(List<CartEntity> cartEntities) throws Exception {
//                                view.loadData(cartEntities);
//                            }
//                        }
//                );
        view.loadData(model.getCartDetail());
    }

    @Override
    public void rxUnsuscribe() {

    }
}
