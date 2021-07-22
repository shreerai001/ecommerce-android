package com.shree.ecom.activityBrowse.model.repositories.used;

import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductEntity;

import io.reactivex.Observable;

public interface UsedPoductRepository {
    Observable<UsedProductEntity> getUsedProduct();

    Observable<UsedProductEntity> getUsedProductFromCache();

    Observable<UsedProductEntity> getUsedProductFromNetwork();
}
