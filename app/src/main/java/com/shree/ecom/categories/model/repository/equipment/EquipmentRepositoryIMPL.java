package com.shree.ecom.categories.model.repository.equipment;

import com.shree.ecom.categories.model.dto.equipment.EquipmentEntity;
import com.shree.ecom.categories.services.EquipmentApiService;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class EquipmentRepositoryIMPL implements EquipmentRepository {
    private EquipmentApiService equipmentApiService;
    List<EquipmentEntity> equipmentEntityList;
    private long timeStamp;

    public EquipmentRepositoryIMPL(EquipmentApiService equipmentApiService) {
        this.equipmentApiService = equipmentApiService;
        this.timeStamp = System.currentTimeMillis();
        equipmentEntityList = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<EquipmentEntity> getEquipment() {
        return getEquipmentFromCache().switchIfEmpty(getEquipmentFromNetwork());
    }

    @Override
    public Observable<EquipmentEntity> getEquipmentFromCache() {
        if (isUpToDate()) {
            return Observable.fromIterable(equipmentEntityList);
        } else {
            timeStamp = System.currentTimeMillis();
            equipmentEntityList.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<EquipmentEntity> getEquipmentFromNetwork() {
        return equipmentApiService.getEquipment();
    }
}
