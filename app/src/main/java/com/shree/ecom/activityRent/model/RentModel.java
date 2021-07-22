package com.shree.ecom.activityRent.model;

import android.content.Context;

import com.shree.ecom.activityRent.contract.RentContract;
import com.shree.ecom.activityRent.model.dto.RentEntity;
import com.shree.ecom.activityRent.repositories.RentRepository;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class RentModel implements RentContract.Model {
    private RentRepository rentRepository;

    public RentModel(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public Observable<BaseResponseEntity> rentProduct(Context context, RentEntity rentEntity) {
        return rentRepository.rentProduct(context, rentEntity);
    }
}
