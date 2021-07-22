package com.shree.ecom.activityProfile.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shree.ecom.activityProfile.contract.ProfileContract;
import com.shree.ecom.activityProfile.model.ProfileActivityModel;
import com.shree.ecom.activityProfile.model.dto.ProfileEntity;
import com.shree.ecom.activityProfile.model.dto.ShippingEntity;
import com.shree.ecom.activityProfile.model.repositories.ProfileRepositories;
import com.shree.ecom.utils.values.NetworkUtils;

import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ProfilePresenter implements ProfileContract.Presenter {

    private ProfileRepositories model;
    private ProfileContract.View view;
    private Disposable disposable;
    private Context context;
    private ProfileActivityModel profileActivityModel;

    public ProfilePresenter(ProfileRepositories model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public void setView(ProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        profileActivityModel = new ProfileActivityModel();
        if (profileActivityModel.getProfileDetail(context) == null) {
            if (NetworkUtils.isNetworkConnected(context)) {
                disposable = model.getProfileDetail()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<ProfileEntity>() {
                            @Override
                            public void onNext(ProfileEntity profileEntity) {
                                view.loadPresonalDetail(profileEntity.getData());

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            } else {
                view.displayMessage("No Internet fetching old data");
                if (retrieveCache() != null) {
                    view.loadPresonalDetail(retrieveCache().getData());
                }
            }
        } else {
            view.loadPresonalDetail(profileActivityModel.getProfileDetail(context));
        }
        if (profileActivityModel.getShippingDetail(context) == null) {
            disposable = model.getShippingDetail()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<ShippingEntity>() {
                        @Override
                        public void onNext(ShippingEntity shippingEntity) {
                            view.loadShippingDetail(shippingEntity.getData());
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            view.loadShippingDetail(profileActivityModel.getShippingDetail(context));
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

    private ProfileEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_profile", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("profile", "");
        ProfileEntity profileEntity = gson.fromJson(json, ProfileEntity.class);
        return profileEntity;
    }
}
