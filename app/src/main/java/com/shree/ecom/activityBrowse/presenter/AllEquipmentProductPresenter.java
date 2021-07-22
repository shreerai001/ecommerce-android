package com.shree.ecom.activityBrowse.presenter;

import android.content.Context;

import com.google.gson.JsonSyntaxException;
import com.shree.ecom.activityBrowse.contract.AllProductContract;
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductDto;
import com.shree.ecom.utils.values.BaseResponseEntity;
import com.shree.ecom.utils.values.CONST;
import com.shree.ecom.utils.values.NetworkUtils;
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

public class AllEquipmentProductPresenter implements AllProductContract.Presenter {

    private static final int API_STATUS_CODE_LOCAL_ERROR = 0;
    private AllProductContract.View view;
    private AllProductContract.Model model;
    private Disposable disposable;
    private Context context;

    public AllEquipmentProductPresenter(AllProductContract.Model model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public void setView(AllProductContract.View view) {
        this.view = view;
    }

    @Override
    public void addAllProductToCart(AllEquipmentProductEntity allEquipmentProductEntity) {
        model.addAllProductToCart(allEquipmentProductEntity);
    }

    @Override
    public void loadData() {
        if (NetworkUtils.isNetworkConnected(context) && view != null) {
            view.progressOn(true);
            disposable = model
                    .getAllEquipmentList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<AllEquipmentProductEntity>() {
                        @Override
                        public void onNext(AllEquipmentProductEntity allEquipmentProductEntity) {
                            if (view != null) {
                                view.progressOn(false);
                                List<AllEquipmentProductDto> equipmentProductEntityList = new ArrayList<>();
                                for (int i = 0; i < allEquipmentProductEntity.getData().size(); i++) {
                                    equipmentProductEntityList.add(allEquipmentProductEntity.getData().get(i));
                                }
                                view.loadData(equipmentProductEntityList);
                            } else {
                                view.displayMessage(CONST.NETWORK_FETCH_ERROR);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (view != null) {
                                handleApiError(e);
                                view.progressOn(false);
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
