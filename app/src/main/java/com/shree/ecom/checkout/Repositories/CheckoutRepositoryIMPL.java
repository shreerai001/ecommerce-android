package com.shree.ecom.checkout.Repositories;

import android.content.Context;

import com.shree.ecom.checkout.model.dto.CheckoutEntity;
import com.shree.ecom.checkout.service.CheckoutService;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class CheckoutRepositoryIMPL extends BaseRepositoryIMPL implements CheckoutRepository {
    private CheckoutService checkoutService;
    private Context context;

    public CheckoutRepositoryIMPL(CheckoutService checkoutService, Context context) {
        super(context);
        this.context = context;
        this.checkoutService = checkoutService;
    }

    @Override
    public Observable<BaseResponseEntity> checkOut(CheckoutEntity checkoutEntity) {
        return checkoutService.checkOut("Bearer " + super.accessToken(context),
                checkoutEntity.getFirsName(),
                checkoutEntity.getLastName(),
                checkoutEntity.getEmail(),
                checkoutEntity.getPhone(),
                checkoutEntity.getAddress1(),
                checkoutEntity.getAddress2(),
                checkoutEntity.getCity(),
                checkoutEntity.getState(),
                checkoutEntity.getCountry(),
                checkoutEntity.getPostcode(),
                checkoutEntity.getOrderNote(),
                String.valueOf(checkoutEntity.getQty()),
                String.valueOf(checkoutEntity.getPrice()),
                String.valueOf(checkoutEntity.getTax()),
                String.valueOf(checkoutEntity.getId())
        );
    }
}
