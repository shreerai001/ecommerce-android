package com.shree.ecom.activityCancelOrders.model;

import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface CancelOrderRepoisotry {
    Observable<BaseResponseEntity> cancelOrder(String id);
}
