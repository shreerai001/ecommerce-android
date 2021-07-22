package com.shree.ecom.activityBrowse.model.repositories.all;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;
import com.shree.ecom.activityBrowse.services.AllEquipmentApiService;
import com.shree.ecom.utils.values.CONST;
import com.shree.ecom.utils.values.DbHelper;
import com.shree.ecom.utils.values.NetworkUtils;
import com.shree.ecom.utils.values.TableName;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class AllEquipmentProductRepositoryIMPL implements AllEquipmentProductRepository {

    private AllEquipmentApiService allEquipmentApiService;
    private long timeStamp;
    private Context context;
    private Disposable disposable;

    public AllEquipmentProductRepositoryIMPL(Context context, AllEquipmentApiService allEquipmentApiService) {
        this.context = context;
        this.allEquipmentApiService = allEquipmentApiService;
        this.timeStamp = System.currentTimeMillis();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<AllEquipmentProductEntity> getEquipment() {
        return getEquipmentFromCache().switchIfEmpty(getEquipmentFromNetwork());
    }

    @Override
    public Observable<AllEquipmentProductEntity> getEquipmentFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return getEquipmentFromNetwork();
        }
    }

    @Override
    public Observable<AllEquipmentProductEntity> getEquipmentFromNetwork() {
        if (NetworkUtils.isNetworkConnected(context)) {
            disposable = allEquipmentApiService.getAllEquipmentProduct()
                    .subscribeOn(Schedulers.io())
                    .subscribeWith(new DisposableObserver<AllEquipmentProductEntity>() {
                        @Override
                        public void onNext(AllEquipmentProductEntity allEquipmentProductEntity) {
                            storeCache(allEquipmentProductEntity);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
            return allEquipmentApiService.getAllEquipmentProduct();
        } else {
            return getEquipmentFromCache();
        }
    }

    @Override
    public boolean addAllEquipmentToCard(AllEquipmentProductEntity allEquipmentProductEntity) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("company", allEquipmentProductEntity.getData().get(0).getManufacture_company());
            contentValues.put("product_id", allEquipmentProductEntity.getData().get(0).getId());
            contentValues.put("product_name", allEquipmentProductEntity.getData().get(0).getName());
            contentValues.put("user_id", allEquipmentProductEntity.getData().get(0).getUser_id());
            contentValues.put("model", allEquipmentProductEntity.getData().get(0).getModel());
            contentValues.put("brand_id", allEquipmentProductEntity.getData().get(0).getBrand_id());
            contentValues.put("image", allEquipmentProductEntity.getData().get(0).getImg());
            contentValues.put("sale_price", allEquipmentProductEntity.getData().get(0).getSale_price());
            contentValues.put("price", allEquipmentProductEntity.getData().get(0).getPrice());
            contentValues.put("condition", allEquipmentProductEntity.getData().get(0).getCondition());
            contentValues.put("description", allEquipmentProductEntity.getData().get(0).getDescription());
            contentValues.put("tax", allEquipmentProductEntity.getData().get(0).getTax());
            contentValues.put("manufacture_year", allEquipmentProductEntity.getData().get(0).getManufacture_year());
            contentValues.put("running_hour", allEquipmentProductEntity.getData().get(0).getRunning_hour());
            contentValues.put("location", allEquipmentProductEntity.getData().get(0).getLocation());
            DbHelper rentalDbHelper = new DbHelper(context);
            rentalDbHelper.insertCartInfo(contentValues, TableName.all_equipment.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void storeCache(AllEquipmentProductEntity allEquipmentProductEntity) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_AllEquipment", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(allEquipmentProductEntity);
            editor.putString("AllEquipmentProductEntity", json);
            editor.apply();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_AllEquipment", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private AllEquipmentProductEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_AllEquipment", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("AllEquipmentProductEntity", "");
        AllEquipmentProductEntity allEquipmentProductEntity = gson.fromJson(json, AllEquipmentProductEntity.class);
        return allEquipmentProductEntity;
    }


}
