package com.shree.ecom.activityBrowse.model;

import com.shree.ecom.activityBrowse.contract.RentalDetailContract;
import com.shree.ecom.activityBrowse.model.dto.rental.detail.RentalEquipmentDetailEntity;
import com.shree.ecom.activityBrowse.model.repositories.rentalDetail.RentalDetailRepository;

import io.reactivex.Observable;

public class RentalDetailModel implements RentalDetailContract.Model {
    private RentalDetailRepository rentalDetailRepository;

    public RentalDetailModel(RentalDetailRepository rentalDetailRepository) {
        this.rentalDetailRepository = rentalDetailRepository;
    }


    @Override
    public Observable<RentalEquipmentDetailEntity> getRentalDetail() {
        return rentalDetailRepository.getRentalDetail();
    }
}
