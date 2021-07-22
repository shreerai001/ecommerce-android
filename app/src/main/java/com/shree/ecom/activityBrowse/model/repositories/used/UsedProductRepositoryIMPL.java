package com.shree.ecom.activityBrowse.model.repositories.used;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalEquipmentEntity;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductEntity;
import com.shree.ecom.activityBrowse.services.UsedProductApiService;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class UsedProductRepositoryIMPL implements UsedPoductRepository {

    private UsedProductApiService usedProductApiService;
    private List<UsedProductEntity> usedProductEntityList;
    private long timeStamp;
    private Context context;
    private Disposable disposable;


    public UsedProductRepositoryIMPL(UsedProductApiService usedProductApiService, Context context) {
        this.usedProductApiService = usedProductApiService;
        this.timeStamp = System.currentTimeMillis();
        usedProductEntityList = new ArrayList<>();
        this.context = context;
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<UsedProductEntity> getUsedProduct() {
        return getUsedProductFromCache().switchIfEmpty(getUsedProductFromNetwork());
    }

    @Override
    public Observable<UsedProductEntity> getUsedProductFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return Observable.empty();
        }
    }

    @Override
    public Observable<UsedProductEntity> getUsedProductFromNetwork() {
        disposable = usedProductApiService.getUsedProduct()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<UsedProductEntity>() {
                    @Override
                    public void onNext(UsedProductEntity usedProductEntity) {
                        storeCache(usedProductEntity);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return usedProductApiService.getUsedProduct();
    }

    private void storeCache(UsedProductEntity usedProductEntity) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_Used", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(usedProductEntity);
            editor.putString("usedProductEntity", json);
            editor.apply();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_Used", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private UsedProductEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_Used", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("usedProductEntity", "");
        UsedProductEntity usedProductEntity = gson.fromJson(json, UsedProductEntity.class);
        return usedProductEntity;
    }
}
