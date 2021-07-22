package com.shree.ecom.checkout.Repositories;

import com.shree.ecom.checkout.model.dto.CheckoutEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface CheckoutRepository {
    Observable<BaseResponseEntity> checkOut(CheckoutEntity checkoutEntity);
}
