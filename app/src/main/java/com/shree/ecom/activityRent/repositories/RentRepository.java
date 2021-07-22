package com.shree.ecom.activityRent.repositories;

import android.content.Context;

import com.shree.ecom.activityRent.model.dto.RentEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface RentRepository {
    Observable<BaseResponseEntity> rentProduct(Context context, RentEntity rentEntity);
}
