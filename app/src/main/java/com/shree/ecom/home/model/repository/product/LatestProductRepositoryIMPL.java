package com.shree.ecom.home.model.repository.product;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.shree.ecom.home.model.dto.FeaturedProductEntity;
import com.shree.ecom.home.model.dto.LatestProductEntity;
import com.shree.ecom.home.services.LatestProductApiService;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LatestProductRepositoryIMPL implements LatestProductRepository {
    private LatestProductApiService productApiService;
    List<LatestProductEntity> productsList;
    private long timeStamp;
    private Context context;
    private Disposable disposable;

    public LatestProductRepositoryIMPL(Context context, LatestProductApiService productApiService) {
        this.context = context;
        this.productApiService = productApiService;
        this.timeStamp = System.currentTimeMillis();
        productsList = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<LatestProductEntity> getProduct() {
        return getProductFromCache().switchIfEmpty(getProductFromNetwork());
    }

    @Override
    public Observable<LatestProductEntity> getProductFromNetwork() {
        return productApiService.getLatestProduct();
    }

    @Override
    public Observable<LatestProductEntity> getProductFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return getProductFromCache();
        } else {
            clearCache();
            timeStamp = System.currentTimeMillis();
            return getProductFromNetwork();
        }
    }

    private void storeCache(LatestProductEntity latestProductEntity) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Latest_product", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(latestProductEntity);
            editor.putString("latestEntity", json);
            editor.apply();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Latest_product", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();

    }

    private FeaturedProductEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Latest_product", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("latestEntity", "");
        FeaturedProductEntity featuredProductEntity = gson.fromJson(json, FeaturedProductEntity.class);
        return featuredProductEntity;
    }
}
