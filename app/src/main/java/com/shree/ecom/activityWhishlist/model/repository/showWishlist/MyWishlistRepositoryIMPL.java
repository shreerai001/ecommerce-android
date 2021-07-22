package com.shree.ecom.activityWhishlist.model.repository.showWishlist;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalEquipmentEntity;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;
import com.shree.ecom.utils.values.CONST;
import com.shree.ecom.activityWhishlist.model.dto.WishlistEntity;
import com.shree.ecom.activityWhishlist.service.MyWishlistApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MyWishlistRepositoryIMPL extends BaseRepositoryIMPL implements MyWishlistRepository {

    private MyWishlistApiService myWishlistApiService;
    private Context context;
    private List<WishlistEntity> wishlistEntityList;
    private long timeStamp;
    private Disposable disposable;

    public MyWishlistRepositoryIMPL(Context context, MyWishlistApiService myWishlistApiService) {
        super(context);
        this.context = context;
        this.myWishlistApiService = myWishlistApiService;
        timeStamp = System.currentTimeMillis();
        wishlistEntityList = new ArrayList<>();
    }

    @Override
    public Observable<WishlistEntity> getWishlistFromNetwork() {
//        disposable = myWishlistApiService.getWishlist("Bearer " + accessToken(context))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableObserver<WishlistEntity>() {
//                    @Override
//                    public void onNext(WishlistEntity wishlistEntity) {
//                        storeCache(wishlistEntity);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
        return myWishlistApiService.getWishlist("Bearer " + accessToken(context));
    }

    @Override
    public Observable<WishlistEntity> getWishlist() {
        return getWishlistFromCache().switchIfEmpty(getWishlistFromNetwork());
    }

    @Override
    public Observable<WishlistEntity> getWishlistFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return getWishlistFromNetwork();
        }

    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    private void storeCache(WishlistEntity wishlistEntity) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("wishlistEntity", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(wishlistEntity);
            editor.putString("wishlistEntity", json);
            editor.commit();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("wishlistEntity", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private WishlistEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("wishlistEntity", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("wishlistEntity", "");
        WishlistEntity wishlistEntity = gson.fromJson(json, WishlistEntity.class);
        return wishlistEntity;
    }
}
