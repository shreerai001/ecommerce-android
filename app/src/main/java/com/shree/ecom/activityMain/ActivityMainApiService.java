package com.shree.ecom.activityMain;

import com.shree.ecom.categories.model.dto.equipment.EquipmentDto;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ActivityMainApiService {
    @GET("")
    Observable<EquipmentDto> getEquipment();

    @GET("")
    Observable<EquipmentDto> getMaterial();

}
