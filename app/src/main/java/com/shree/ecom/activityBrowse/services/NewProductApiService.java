package com.shree.ecom.activityBrowse.services;

import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductsEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NewProductApiService {
    @GET("new-products")
    Observable<NewProductsEntity> getNewProducts();
}
