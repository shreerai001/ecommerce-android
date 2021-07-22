package com.shree.ecom.activityRequestProduct.model.repositories;

import android.content.Context;

import com.shree.ecom.activityRequestProduct.model.dto.RequestProductEntity;
import com.shree.ecom.activityRequestProduct.service.RequestProductApiService;
import com.shree.ecom.utils.mvp.BaseRepository;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class RequestProductRepositoryIMPL extends BaseRepository implements RequestProductRepository {
    private RequestProductApiService requestProductApiService;

    public RequestProductRepositoryIMPL(RequestProductApiService requestProductApiService) {
        this.requestProductApiService = requestProductApiService;
    }

    @Override
    public Observable<BaseResponseEntity> requestProduct(Context context, RequestProductEntity requestProductEntity) {
        return requestProductApiService.requestProduct(super.accessToken(context),
                String.valueOf(requestProductEntity.getCategoryId()),
                requestProductEntity.getBrandId(),
                requestProductEntity.getFirstName(),
                requestProductEntity.getPhone(),
                requestProductEntity.getLastName(),
                requestProductEntity.getCompany(),
                requestProductEntity.getEmail(),
                requestProductEntity.getModel(),
                requestProductEntity.getPurpose(),
                requestProductEntity.getCondition(),
                requestProductEntity.getPrice(),
                requestProductEntity.getManufactureCompany(),
                requestProductEntity.getMessage(),
                requestProductEntity.getYear(),
                requestProductEntity.getHour()
        );
    }

    @Override
    public boolean checkdLoggedIn() {
        return true;
    }
}
