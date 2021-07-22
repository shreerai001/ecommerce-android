package com.shree.ecom.activityProfile.model.repositories;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shree.ecom.activityProfile.model.ProfileActivityModel;
import com.shree.ecom.activityProfile.model.dto.ProfileEntity;
import com.shree.ecom.activityProfile.model.dto.ShippingEntity;
import com.shree.ecom.activityProfile.services.ProfileApiService;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;
import com.shree.ecom.utils.values.CONST;
import com.shree.ecom.utils.values.NetworkUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ProfileRepositoryIMPL extends BaseRepositoryIMPL implements ProfileRepositories {
    private List<ProfileEntity> profileEntityList;
    private List<ShippingEntity> shippingEntityList;
    private ProfileApiService profileApiService;
    private long timeStamp;
    private Context context;
    private Disposable disposable;
    ProfileActivityModel profileActivityModel;

    public ProfileRepositoryIMPL(Context context, ProfileApiService profileApiService) {
        super(context);
        this.context = context;
        this.profileApiService = profileApiService;
        profileEntityList = new ArrayList<>();
        shippingEntityList = new ArrayList<>();
        timeStamp = System.currentTimeMillis();
    }

    @Override
    public Observable<ProfileEntity> getProfileDetail() {
        return getProfileDetailFromCache().switchIfEmpty(getProfileDetailFromNetwork());
    }

    @Override
    public Observable<ProfileEntity> getProfileDetailFromNetwork() {
        profileActivityModel = new ProfileActivityModel();
        disposable = profileApiService
                .getProfileDetail("Bearer " + accessToken(context))
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<ProfileEntity>() {
                    @Override
                    public void onNext(ProfileEntity profileEntity) {
                        profileActivityModel = new ProfileActivityModel();
                        profileActivityModel.insertProfileDetail(context, profileEntity.getData());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return profileApiService.getProfileDetail("Bearer " + accessToken(context));
    }

    @Override
    public Observable<ProfileEntity> getProfileDetailFromCache() {
        if (isUpToDate() && getShippingDetailFromCahce() != null) {
            return Observable.fromIterable(profileEntityList);
        } else {
            timeStamp = System.currentTimeMillis();
            profileEntityList.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<ShippingEntity> getShippingDetail() {
        return getShippingDetailFromCahce().switchIfEmpty(getShippingDetailFromNetwork());
    }

    @Override
    public Observable<ShippingEntity> getShippingDetailFromNetwork() {
        disposable = profileApiService
                .getShippingDetail("Bearer " + accessToken(context))
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<ShippingEntity>() {
                    @Override
                    public void onNext(ShippingEntity shippingEntity) {
                        profileActivityModel = new ProfileActivityModel();
                        profileActivityModel.insertShippingDetail(context, shippingEntity.getData());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return profileApiService.getShippingDetail("Bearer " + accessToken(context));
    }

    @Override
    public Observable<ShippingEntity> getShippingDetailFromCahce() {
        if (isUpToDate()) {
            return Observable.fromIterable(shippingEntityList);
        } else {
            timeStamp = System.currentTimeMillis();
            shippingEntityList.clear();
            return Observable.empty();
        }
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.LONG_STALE_MS;
    }

}
