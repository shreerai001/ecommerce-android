package com.shree.ecom.activityBrowse.model.repositories.rentalDetail;

import com.shree.ecom.activityBrowse.model.dto.rental.detail.RentalEquipmentDetailEntity;
import com.shree.ecom.activityBrowse.services.RentalApiService;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class RentalDetailRepositoryIMPL implements RentalDetailRepository {

    private RentalApiService rentalApiService;
    private List<RentalEquipmentDetailEntity> rentalEquipmentDetailEntityList;
    private long timeStamp_V;

    public RentalDetailRepositoryIMPL(RentalApiService rentalApiService) {
        this.rentalApiService = rentalApiService;
        timeStamp_V = System.currentTimeMillis();
        rentalEquipmentDetailEntityList = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp_V < CONST.STALE_MS;
    }

    @Override
    public Observable<RentalEquipmentDetailEntity> getRentalDetail() {
        return getRentalDetailFromCache().switchIfEmpty(getRentalDetailFromNetwork());
    }

    @Override
    public Observable<RentalEquipmentDetailEntity> getRentalDetailFromCache() {
        if (isUpToDate()) {
            return Observable.fromIterable(rentalEquipmentDetailEntityList);
        } else {
            timeStamp_V = System.currentTimeMillis();
            rentalEquipmentDetailEntityList.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<RentalEquipmentDetailEntity> getRentalDetailFromNetwork() {
        return rentalApiService.getRentalDetail();
    }
}
