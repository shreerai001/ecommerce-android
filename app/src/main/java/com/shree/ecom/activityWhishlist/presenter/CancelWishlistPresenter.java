package com.shree.ecom.activityWhishlist.presenter;

import android.content.Context;

import com.shree.ecom.utils.values.BaseResponseEntity;
import com.shree.ecom.activityWhishlist.contract.CancelWishlistContract;
import com.shree.ecom.utils.values.NetworkUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CancelWishlistPresenter implements CancelWishlistContract.Presenter {
    private CancelWishlistContract.Model wishlistModel;
    private Disposable disposable;
    private CancelWishlistContract.View view;
    private Context context;

    public CancelWishlistPresenter(CancelWishlistContract.Model wishlistModel, Context context) {
        this.wishlistModel = wishlistModel;
        this.context = context;
    }

    @Override
    public void setView(CancelWishlistContract.View view) {
        this.view = view;
    }

    @Override
    public void cancelWishList(String productId) {
        if (NetworkUtils.isNetworkConnected(context)) {
            view.progressOn(true);
            disposable = wishlistModel
                    .cancelWishtlist(productId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<BaseResponseEntity>() {
                        @Override
                        public void onNext(BaseResponseEntity baseResponseEntity) {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {
                            view.progressOn(false);
                            view.displayMessage("Product removed from wishlist");
                        }
                    });
        }
    }


    @Override
    public void loadData() {

    }

    @Override
    public void rxUnsuscribe() {

    }


}
