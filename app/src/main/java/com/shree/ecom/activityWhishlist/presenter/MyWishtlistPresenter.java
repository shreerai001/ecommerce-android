package com.shree.ecom.activityWhishlist.presenter;

import android.content.Context;

import com.shree.ecom.activityWhishlist.contract.MyWishlistContract;
import com.shree.ecom.activityWhishlist.model.dto.WishlistEntity;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;
import com.shree.ecom.utils.values.NetworkUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * This class retrives wishlist from user account
 */
public class MyWishtlistPresenter extends BaseRepositoryIMPL implements MyWishlistContract.Presenter {

    private Disposable disposable;
    private MyWishlistContract.Model wishlistModel;
    private MyWishlistContract.View view;

    public MyWishtlistPresenter(Context context, MyWishlistContract.Model wishlistModel) {
        super(context);
        this.wishlistModel = wishlistModel;
    }

    @Override
    public void loadData() {
        if (NetworkUtils.isNetworkConnected(context)) {
            if (view != null) {
                disposable = wishlistModel.getWishList()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<WishlistEntity>() {
                            @Override
                            public void onNext(WishlistEntity wishlistEntity) {
                                view.lodaData(wishlistEntity.getData());
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        }
//        disposable = wishlistModel.getWishList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        new Consumer<WishlistEntity>() {
//                            @Override
//                            public void accept(WishlistEntity wishlistEntity) throws Exception {
//                                if (view != null) {
//                                    view.lodaData(wishlistEntity.getData());
//                                }
//                            }
//                        }
//                );
    }

    @Override
    public void setView(MyWishlistContract.View view) {
        this.view = view;
    }

    @Override
    public void rxUnsuscribe() {

    }

    @Override
    public boolean checkdLoggedIn() {
        return super.checkdLoggedIn();
    }
}
