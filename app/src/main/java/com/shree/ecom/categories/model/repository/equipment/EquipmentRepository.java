package com.shree.ecom.categories.model.repository.equipment;

import com.shree.ecom.categories.model.dto.equipment.EquipmentEntity;

import io.reactivex.Observable;

public interface EquipmentRepository {
    Observable<EquipmentEntity> getEquipment();

    Observable<EquipmentEntity> getEquipmentFromCache();

    Observable<EquipmentEntity> getEquipmentFromNetwork();
}
