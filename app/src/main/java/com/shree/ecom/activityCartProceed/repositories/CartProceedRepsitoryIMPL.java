package com.shree.ecom.activityCartProceed.repositories;

import android.content.Context;

import com.shree.ecom.activityCartProceed.model.dto.CartProceedEntity;
import com.shree.ecom.activityCartProceed.service.CartProceedApiService;
import com.shree.ecom.utils.mvp.BaseRepository;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class CartProceedRepsitoryIMPL extends BaseRepository implements CartProceedRepository {

    private CartProceedApiService cartProceedApiService;
    private Context context;

    public CartProceedRepsitoryIMPL(Context context, CartProceedApiService cartProceedApiService) {
        this.cartProceedApiService = cartProceedApiService;
        this.context = context;
    }

    @Override
    public Observable<BaseResponseEntity> proceedCart(CartProceedEntity cartProceedEntity) {
        return cartProceedApiService.proceedCart(accessToken(context),
                cartProceedEntity.getFirstName(),
                cartProceedEntity.getLastName(),
                cartProceedEntity.getEmail(),
                cartProceedEntity.getPhone(),
                cartProceedEntity.getAddress1(),
                cartProceedEntity.getAddress2(),
                cartProceedEntity.getCity(),
                cartProceedEntity.getState(),
                cartProceedEntity.getCountry(),
                cartProceedEntity.getPostcode(),
                cartProceedEntity.getOrderNote(),
                cartProceedEntity.getQty(),
                cartProceedEntity.getPrice(),
                cartProceedEntity.getTax(),
                cartProceedEntity.getCartid()
        );
    }

    @Override
    public boolean checkdLoggedIn() {
        return false;
    }
}
