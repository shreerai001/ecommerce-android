package com.shree.ecom.activityMyOrders.model.repositories;

import com.shree.ecom.activityMyOrders.model.dto.MyOrdersEntity;

import io.reactivex.Observable;

public interface MyOrdersRepository {
    Observable<MyOrdersEntity> getMyOrders();

    Observable<MyOrdersEntity> getMyOrdersFromNetwork();

    Observable<MyOrdersEntity> getMyOrdersFromCache();
}
