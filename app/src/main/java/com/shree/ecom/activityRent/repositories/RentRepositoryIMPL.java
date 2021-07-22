package com.shree.ecom.activityRent.repositories;

import android.content.Context;

import com.shree.ecom.activityRent.model.dto.RentEntity;
import com.shree.ecom.activityRent.services.RentApiService;
import com.shree.ecom.utils.mvp.BaseRepository;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class RentRepositoryIMPL extends BaseRepository implements RentRepository {

    private RentApiService rentalApiService;

    public RentRepositoryIMPL(RentApiService rentalApiService) {
        this.rentalApiService = rentalApiService;
    }

    @Override
    public Observable<BaseResponseEntity> rentProduct(Context context, RentEntity rentEntity) {
        return rentalApiService.rentPrdouct(accessToken(context),
                String.valueOf(rentEntity.getId()),
                rentEntity.getCompany(),
                rentEntity.getFirstName(),
                rentEntity.getLastName(),
                rentEntity.getEmail(),
                rentEntity.getPhone(),
                rentEntity.getAddress(),
                rentEntity.getCity(),
                rentEntity.getState(),
                rentEntity.getZipCode(),
                rentEntity.getMessage());
    }

    @Override
    public boolean checkdLoggedIn() {
        return true;
    }
}
