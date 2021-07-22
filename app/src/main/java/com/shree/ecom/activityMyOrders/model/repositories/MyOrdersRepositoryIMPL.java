package com.shree.ecom.activityMyOrders.model.repositories;

import android.content.Context;

import com.shree.ecom.activityMyOrders.model.dto.MyOrdersEntity;
import com.shree.ecom.activityMyOrders.services.MyOrdersApiService;
import com.shree.ecom.utils.mvp.BaseRepository;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class MyOrdersRepositoryIMPL extends BaseRepository implements MyOrdersRepository {
    private MyOrdersApiService myOrdersApiService;
    private long timeStamp;
    private List<MyOrdersEntity> myOrdersEntityList;
    private Context context_dco;

    public MyOrdersRepositoryIMPL(Context context, MyOrdersApiService myOrdersApiService) {
        this.context_dco = context;
        this.myOrdersApiService = myOrdersApiService;
        myOrdersEntityList = new ArrayList<>();
        timeStamp = System.currentTimeMillis();
    }

    @Override
    public Observable<MyOrdersEntity> getMyOrders() {
        return getMyOrdersFromCache().switchIfEmpty(getMyOrdersFromNetwork());
    }

    @Override
    public Observable<MyOrdersEntity> getMyOrdersFromNetwork() {
        return myOrdersApiService.getMyEntity("Bearer "+accessToken(context_dco));
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<MyOrdersEntity> getMyOrdersFromCache() {
        if (isUpToDate()) {
            return Observable.fromIterable(myOrdersEntityList);
        } else {
            timeStamp = System.currentTimeMillis();
            myOrdersEntityList.clear();
            return Observable.empty();
        }
    }

    @Override
    public boolean checkdLoggedIn() {
        return false;
    }
}
