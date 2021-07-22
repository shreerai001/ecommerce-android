package com.shree.ecom.categories.services;

import com.shree.ecom.categories.model.dto.equipment.EquipmentEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface EquipmentApiService {
    @GET("categories/equipment")
    Observable<EquipmentEntity> getEquipment();
}
