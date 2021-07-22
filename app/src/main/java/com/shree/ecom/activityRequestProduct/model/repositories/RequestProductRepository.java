package com.shree.ecom.activityRequestProduct.model.repositories;

import android.content.Context;

import com.shree.ecom.activityRequestProduct.model.dto.RequestProductEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface RequestProductRepository {
    Observable<BaseResponseEntity> requestProduct(Context context, RequestProductEntity requestProductEntity);
}
