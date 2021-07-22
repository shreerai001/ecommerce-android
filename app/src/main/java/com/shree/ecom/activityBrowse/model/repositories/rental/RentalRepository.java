package com.shree.ecom.activityBrowse.model.repositories.rental;

import com.shree.ecom.activityBrowse.model.dto.rental.RentalCartDto;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalDataDto;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalEquipmentEntity;

import io.reactivex.Observable;

public interface RentalRepository {
    Observable<RentalEquipmentEntity> getRentalEntity();

    Observable<RentalEquipmentEntity> getRentalEntityFromCache();

    Observable<RentalEquipmentEntity> getRentalEntityFromNetwork();

    boolean addRentalToCart(RentalCartDto rentalCartDto);
}
