package com.shree.ecom.activityBrowse.model.rental;

import com.shree.ecom.activityBrowse.contract.RentalContract;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalCartDto;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalEquipmentEntity;
import com.shree.ecom.activityBrowse.model.repositories.rental.RentalRepository;

import io.reactivex.Observable;

public class RentalModel implements RentalContract.Model {
    private RentalRepository rentalRepository;

    public RentalModel(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public Observable<RentalEquipmentEntity> getRentalEntity() {
        return rentalRepository.getRentalEntity();
    }

    @Override
    public boolean saveRentalCart(RentalCartDto rentalCartDto) {
        return rentalRepository.addRentalToCart(rentalCartDto);
    }
}
