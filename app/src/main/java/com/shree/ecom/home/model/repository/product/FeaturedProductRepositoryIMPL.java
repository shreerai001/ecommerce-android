package com.shree.ecom.home.model.repository.product;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.shree.ecom.home.model.dto.FeaturedProductEntity;
import com.shree.ecom.home.services.FeaturedProductApiService;
import com.shree.ecom.utils.values.CONST;
import com.shree.ecom.utils.values.NetworkUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class FeaturedProductRepositoryIMPL implements FeaturedProductRepository {
    private FeaturedProductApiService productApiService;
    private long timeStamp;
    private Disposable disposable;
    private Context context;

    public FeaturedProductRepositoryIMPL(Context context, FeaturedProductApiService productApiService) {
        this.context = context;
        this.productApiService = productApiService;
        this.timeStamp = System.currentTimeMillis();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<FeaturedProductEntity> getProduct() {
        return getProductFromCache().switchIfEmpty(getProductFromNetwork());
    }

    @Override
    public Observable<FeaturedProductEntity> getProductFromNetwork() {
        if (NetworkUtils.isNetworkConnected(context)) {
            disposable = productApiService.getLatestProduct()
                    .subscribeOn(Schedulers.io())
                    .subscribeWith(new DisposableObserver<FeaturedProductEntity>() {
                        @Override
                        public void onNext(FeaturedProductEntity featuredProductEntity) {
                            storeCache(featuredProductEntity);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });

            return productApiService.getLatestProduct();
        } else {
            return getProductFromCache();
        }
    }

    @Override
    public Observable<FeaturedProductEntity> getProductFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            clearCache();
            timeStamp = System.currentTimeMillis();
            return getProductFromNetwork();
        }
    }

    private void storeCache(FeaturedProductEntity featuredProductEntity) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Featured_Equipment", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(featuredProductEntity);
            editor.putString("FeaturedEntity", json);
            editor.apply();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Featured_Equipment", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();

    }

    private FeaturedProductEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Featured_Equipment", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("FeaturedEntity", "");
        return gson.fromJson(json, FeaturedProductEntity.class);
    }


}
