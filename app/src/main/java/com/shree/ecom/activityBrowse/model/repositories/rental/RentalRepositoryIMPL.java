package com.shree.ecom.activityBrowse.model.repositories.rental;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalCartDto;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalEquipmentEntity;
import com.shree.ecom.activityBrowse.services.RentalApiService;
import com.shree.ecom.utils.values.CONST;
import com.shree.ecom.utils.values.DbHelper;
import com.shree.ecom.utils.values.TableName;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RentalRepositoryIMPL implements RentalRepository {
    private RentalApiService rentalApiService;
    private List<RentalEquipmentEntity> rentalEquipmentEntityList;
    private long timeStamp;
    private Context context_dco;
    private Disposable disposable;

    public RentalRepositoryIMPL(RentalApiService rentalApiService, Context context) {
        this.rentalApiService = rentalApiService;
        this.timeStamp = System.currentTimeMillis();
        rentalEquipmentEntityList = new ArrayList<>();
        this.context_dco = context;
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<RentalEquipmentEntity> getRentalEntity() {
        return getRentalEntityFromCache().switchIfEmpty(getRentalEntityFromNetwork());
    }

    @Override
    public Observable<RentalEquipmentEntity> getRentalEntityFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return getRentalEntityFromNetwork();
        }
    }

    @Override
    public Observable<RentalEquipmentEntity> getRentalEntityFromNetwork() {
        disposable = rentalApiService.getRental()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<RentalEquipmentEntity>() {
                    @Override
                    public void onNext(RentalEquipmentEntity rentalEquipmentEntity) {
                        storeCache(rentalEquipmentEntity);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return rentalApiService.getRental();
    }

    @Override
    public boolean addRentalToCart(RentalCartDto rentalCartDto) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("company", rentalCartDto.getCompany());
            contentValues.put("product_id", rentalCartDto.getRental_product_id());
            contentValues.put("product_name", rentalCartDto.getProductName());
            contentValues.put("user_id", rentalCartDto.getUserId());
            contentValues.put("model", rentalCartDto.getModel());
            contentValues.put("brand_id", rentalCartDto.getBrand_id());
            contentValues.put("image", rentalCartDto.getImage());
            DbHelper rentalDbHelper = new DbHelper(context_dco);
            rentalDbHelper.insertCartInfo(contentValues, TableName.rent_equipment.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void storeCache(RentalEquipmentEntity rentalEquipmentEntity) {
        try {
            SharedPreferences sharedPreferences = context_dco.getSharedPreferences("Cache_Rental", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(rentalEquipmentEntity);
            editor.putString("RentalEquipmentEntity", json);
            editor.apply();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context_dco.getSharedPreferences("Cache_Rental", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private RentalEquipmentEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context_dco.getSharedPreferences("Cache_Rental", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("RentalEquipmentEntity", "");
        RentalEquipmentEntity rentalEquipmentEntity = gson.fromJson(json, RentalEquipmentEntity.class);
        return rentalEquipmentEntity;
    }
}
