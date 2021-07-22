package com.shree.ecom.activityWhishlist.presenter;

import android.content.Context;

import com.google.gson.JsonSyntaxException;
import com.shree.ecom.utils.values.BaseResponseEntity;
import com.shree.ecom.activityWhishlist.contract.WishlistContract;
import com.shree.ecom.utils.values.ErrorEntity;
import com.shree.ecom.utils.values.NetworkUtils;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * This class adds products to wishlist to user account
 * To add wishlist WishlistContract.View must be implemented and inject this class
 */
public class WishlistPresenter implements WishlistContract.Presenter {
    private static final int API_STATUS_CODE_LOCAL_ERROR = 1;
    private WishlistContract.Model wishlistModel;
    private Disposable disposable;
    private WishlistContract.View view;
    private Context context;

    public WishlistPresenter(WishlistContract.Model wishlistModel, Context context) {
        this.wishlistModel = wishlistModel;
        this.context = context;
    }

    @Override
    public void setView(WishlistContract.View view) {
        this.view = view;
    }

    @Override
    public void addToWishlist(String productId) {
        if (NetworkUtils.isNetworkConnected(context) && view != null) {
            view.progressOn(true);
            disposable = wishlistModel
                    .addToWishlist(productId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<BaseResponseEntity>() {
                        @Override
                        public void onNext(BaseResponseEntity baseResponseEntity) {
                            if (view != null) {
                                view.displayMessage("Sucessfully added product to wishlist");
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            handleApiError(e);
                        }

                        @Override
                        public void onComplete() {
                            if (view != null) {
                                view.progressOn(false);
                            }
                        }
                    });
        } else {
            view.displayMessage("No Internet connection");
        }
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

    public void handleApiError(Throwable error) {
        if (error instanceof HttpException) {
            switch (((HttpException) error).code()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                    view.displayMessage("Unauthorised User");
                    break;
                case HttpsURLConnection.HTTP_FORBIDDEN:
                    view.displayMessage("Forbidden");
                    break;
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                    view.displayMessage("Internal Server Error");
                    break;
                case HttpsURLConnection.HTTP_BAD_REQUEST:
                    view.displayMessage("Bad Request");
                    break;
                case API_STATUS_CODE_LOCAL_ERROR:
                    view.displayMessage("No Internet Connection");
                    break;
                default:
                    view.displayMessage(error.getLocalizedMessage());

            }
        } else if (error instanceof ErrorEntity) {
            view.displayMessage(error.getMessage());
        } else if (error instanceof JsonSyntaxException) {
            view.displayMessage("Something Went Wrong API is not responding properly!");
        } else {
            view.displayMessage(error.getMessage());
        }

    }


}
