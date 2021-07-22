package com.shree.ecom.categories.model;

import com.shree.ecom.categories.contract.EquipmentContract;
import com.shree.ecom.categories.model.dto.equipment.EquipmentEntity;
import com.shree.ecom.categories.model.repository.equipment.EquipmentRepository;

import io.reactivex.Observable;

public class EquipmentModel implements EquipmentContract.Model {
    private EquipmentRepository equipmentRepository;

    public EquipmentModel(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Observable<EquipmentEntity> getEquipmentData() {
        return equipmentRepository.getEquipment();
    }
}
