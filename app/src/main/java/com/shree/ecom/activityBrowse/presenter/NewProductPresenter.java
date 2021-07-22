package com.shree.ecom.activityBrowse.presenter;

import com.google.gson.JsonSyntaxException;
import com.shree.ecom.activityBrowse.contract.NewProductContract;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductDataDto;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductsEntity;
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

public class NewProductPresenter implements NewProductContract.Presenter {
    private static final int API_STATUS_CODE_LOCAL_ERROR = 0;
    private NewProductContract.View view;
    private NewProductContract.Model model;
    private Disposable disposable;

    public NewProductPresenter(NewProductContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(NewProductContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        if (view != null) {
            view.progressOn(true);
        }
        disposable = model
                .getProductsEntity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<NewProductsEntity>() {
                    @Override
                    public void onNext(NewProductsEntity newProductsEntity) {
                        if (view != null) {
                            view.progressOn(false);
                            List<NewProductDataDto> newProductDataDtoList = new ArrayList<>();
                            for (int i = 0; i < newProductsEntity.getData().size(); i++) {
                                newProductDataDtoList.add(newProductsEntity.getData().get(i));
                            }
                            view.loadData(newProductDataDtoList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            handleApiError(e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


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
