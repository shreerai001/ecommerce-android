package com.shree.ecom.activityBrowse.model.repositories.newProduct;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductsEntity;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalEquipmentEntity;
import com.shree.ecom.activityBrowse.services.NewProductApiService;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NewProductRepositoryIMPL implements NewProductRepository {

    private NewProductApiService newProductApiService;
    private List<NewProductsEntity> newProductsEntityList;
    private long timeStamp;
    private Context context;
    private Disposable disposable;

    public NewProductRepositoryIMPL(Context context, NewProductApiService newProductApiService) {
        this.context = context;
        this.newProductApiService = newProductApiService;
        this.timeStamp = System.currentTimeMillis();
        newProductsEntityList = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<NewProductsEntity> getNewProduct() {
        return getNewProductFromCache().switchIfEmpty(getNewProductFromNetwork());
    }

    @Override
    public Observable<NewProductsEntity> getNewProductFromCache() {
        if (isUpToDate() && retrieveCache()!=null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return getNewProductFromNetwork();
        }
    }

    @Override
    public Observable<NewProductsEntity> getNewProductFromNetwork() {
        disposable = newProductApiService.getNewProducts()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<NewProductsEntity>() {
                    @Override
                    public void onNext(NewProductsEntity newProductsEntity) {
                        storeCache(newProductsEntity);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return newProductApiService.getNewProducts();
    }

    private void storeCache(NewProductsEntity newProductsEntity) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_NewProducts", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(newProductsEntity);
            editor.putString("NewProductsEntity", json);
            editor.apply();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_NewProducts", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private NewProductsEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_NewProducts", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("NewProductsEntity", "");
        NewProductsEntity newProductsEntity = gson.fromJson(json, NewProductsEntity.class);
        return newProductsEntity;
    }


}
