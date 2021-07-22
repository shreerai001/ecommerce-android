package com.shree.ecom.activityBrowse.services;

import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductsEntity;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UsedProductApiService {
    @GET("used-products")
    Observable<UsedProductEntity> getUsedProduct();
}
