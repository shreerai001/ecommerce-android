package com.shree.ecom.checkout.model;

import com.shree.ecom.activityBrowse.model.dto.PersonalCartDto;
import com.shree.ecom.activityProfile.model.ProfileActivityModel;
import com.shree.ecom.checkout.Repositories.CheckoutRepository;
import com.shree.ecom.checkout.contract.CheckoutContract;
import com.shree.ecom.checkout.model.dto.CheckoutEntity;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class CheckoutModel extends ProfileActivityModel implements CheckoutContract.Model {
    private CheckoutRepository checkoutRepository;

    public CheckoutModel(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    @Override
    public Observable<BaseResponseEntity> addToCart(CheckoutEntity checkoutEntity) {
        return checkoutRepository.checkOut(checkoutEntity);
    }

    @Override
    public PersonalCartDto getPersonalDetail() {
        return null;
    }
}
