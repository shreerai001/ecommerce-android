package com.shree.ecom.activityBrowse.presenter;

import com.google.gson.JsonSyntaxException;
import com.shree.ecom.activityBrowse.contract.NewProductContract;
import com.shree.ecom.activityBrowse.contract.UsedProductContract;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductDataDto;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductsEntity;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductDataDto;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductEntity;
import com.shree.ecom.utils.values.WrapperError;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

public class UsedProductPresenter implements UsedProductContract.Presenter {
    private static final int API_STATUS_CODE_LOCAL_ERROR = 0;
    private UsedProductContract.View view;
    private UsedProductContract.Model model;
    private Disposable disposable;

    public UsedProductPresenter(UsedProductContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(UsedProductContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        if (view != null) {
            view.progressOn(true);
            disposable = model
                    .getProductsEntity()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<UsedProductEntity>() {
                        @Override
                        public void onNext(UsedProductEntity usedProductEntity) {
                            if (view != null) {
                                view.progressOn(false);
                                List<UsedProductDataDto> productEntityList = new ArrayList<>();
                                for (int i = 0; i < usedProductEntity.getData().size(); i++) {
                                    productEntityList.add(usedProductEntity.getData().get(i));
                                }
                                view.loadData(productEntityList);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (view != null) {
                                view.progressOn(false);
                                handleApiError(e);
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    @Override
    public void rxUnsuscribe() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }

    private void handleApiError(Throwable error) {
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
                case HttpsURLConnection.HTTP_CLIENT_TIMEOUT:
                    view.displayMessage("Quitting");
                    break;
                case API_STATUS_CODE_LOCAL_ERROR:
                    view.displayMessage("No Internet Connection");
                    break;
                default:
                    view.displayMessage(error.getLocalizedMessage());
            }
        } else if (error instanceof WrapperError) {
            view.displayMessage(error.getMessage());
        } else if (error instanceof JsonSyntaxException) {
            view.displayMessage("Something Went Wrong API is not responding properly!");
        } else {
            view.displayMessage(error.getMessage());
        }

    }
}
