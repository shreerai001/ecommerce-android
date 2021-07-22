package com.shree.ecom.activityBrowse.model.repositories.all;

import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductDto;
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;

import io.reactivex.Observable;

public interface AllEquipmentProductRepository {
    Observable<AllEquipmentProductEntity> getEquipment();

    Observable<AllEquipmentProductEntity> getEquipmentFromCache();

    Observable<AllEquipmentProductEntity> getEquipmentFromNetwork();

    boolean addAllEquipmentToCard(AllEquipmentProductEntity allEquipmentProductEntity);
}
