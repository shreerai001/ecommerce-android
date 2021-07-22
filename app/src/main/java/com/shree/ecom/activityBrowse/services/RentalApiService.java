package com.shree.ecom.activityBrowse.services;

import com.shree.ecom.activityBrowse.model.dto.rental.RentalEquipmentEntity;
import com.shree.ecom.activityBrowse.model.dto.rental.detail.RentalEquipmentDetailEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RentalApiService {

    @GET("rental-products")
    Observable<RentalEquipmentEntity> getRental();

    @POST("rental-product")
    Observable<RentalEquipmentDetailEntity> getRentalDetail();
}
