package com.shree.ecom.activityRequestProduct.model;

import android.content.Context;

import com.shree.ecom.activityRequestProduct.contract.RequestProductContract;
import com.shree.ecom.activityRequestProduct.model.dto.RequestProductEntity;
import com.shree.ecom.activityRequestProduct.model.repositories.RequestProductRepository;
import com.shree.ecom.activityRequestProduct.service.RequestProductApiService;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class RequestProductModel implements RequestProductContract.Model {

    private RequestProductRepository requestProductRepository;

    public RequestProductModel(RequestProductRepository requestProductRepository) {
        this.requestProductRepository = requestProductRepository;
    }

    @Override
    public Observable<BaseResponseEntity> requestProduct(Context context, RequestProductEntity requestProductEntity) {
        return requestProductRepository.requestProduct(context, requestProductEntity);
    }
}
