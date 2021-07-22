package com.shree.ecom.activityCancelOrders.model;

import android.content.Context;

import com.shree.ecom.activityCancelOrders.services.CancelOrderContractApiService;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class CancelOrderRepositoryIMPL extends BaseRepositoryIMPL implements CancelOrderRepoisotry {
    private CancelOrderContractApiService cancelOrderContractApiService;
    private Context context;

    public CancelOrderRepositoryIMPL(Context contetxt, CancelOrderContractApiService cancelOrderContractApiService) {
        super(contetxt);
        this.context = contetxt;
        this.cancelOrderContractApiService = cancelOrderContractApiService;
    }

    @Override
    public Observable<BaseResponseEntity> cancelOrder(String id) {
        return cancelOrderContractApiService.getReviews("Bearer " + accessToken(context), id);
    }
}
