package com.shree.ecom.activityBrowse.services;

import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface AllEquipmentApiService {
    @GET("products")
    Observable<AllEquipmentProductEntity> getAllEquipmentProduct();
}
