package com.shree.ecom.activityBrowse.model.repositories.rentalDetail;

import com.shree.ecom.activityBrowse.model.dto.rental.detail.RentalEquipmentDetailEntity;

import io.reactivex.Observable;

public interface RentalDetailRepository {
    Observable<RentalEquipmentDetailEntity> getRentalDetail();

    Observable<RentalEquipmentDetailEntity> getRentalDetailFromCache();

    Observable<RentalEquipmentDetailEntity> getRentalDetailFromNetwork();
}
