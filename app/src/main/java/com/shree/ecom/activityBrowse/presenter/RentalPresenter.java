package com.shree.ecom.activityBrowse.presenter;

import com.google.gson.JsonSyntaxException;
import com.shree.ecom.activityBrowse.contract.RentalContract;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalCartDto;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalDataDto;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalEquipmentEntity;
import com.shree.ecom.utils.values.CONST;
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

public class RentalPresenter implements RentalContract.Presenter {
    private static final int API_STATUS_CODE_LOCAL_ERROR = 0;
    private RentalContract.View view;
    private RentalContract.Model model;
    private Disposable disposable;

    public RentalPresenter(RentalContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(RentalContract.View view) {
        this.view = view;
    }

    @Override
    public void addRentalCart(RentalCartDto rentalCartDto) {
        if (model.saveRentalCart(rentalCartDto)) {
            view.displayMessage(CONST.ADDED_TO_CART);

        } else {
            view.displayMessage(CONST.ADDED_TO_CART_FAILED);
        }
    }

    @Override
    public void loadData() {
        if (view != null) {
            view.progressOn(true);
            disposable = model
                    .getRentalEntity()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<RentalEquipmentEntity>() {
                        @Override
                        public void onNext(RentalEquipmentEntity rentalEquipmentEntity) {
                            view.progressOn(false);
                            List<RentalDataDto> rentalDataDtoList = new ArrayList<>();
                            for (int i = 0; i < rentalEquipmentEntity.getData().size(); i++) {
                                rentalDataDtoList.add(rentalEquipmentEntity.getData().get(i));
                            }
                            view.loadData(rentalDataDtoList);
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
