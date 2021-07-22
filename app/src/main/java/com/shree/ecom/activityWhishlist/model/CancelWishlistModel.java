package com.shree.ecom.activityWhishlist.model;

import com.shree.ecom.utils.values.BaseResponseEntity;
import com.shree.ecom.activityWhishlist.contract.CancelWishlistContract;
import com.shree.ecom.activityWhishlist.model.repository.cancelWishlist.CancelWishlistRepository;

import io.reactivex.Observable;

public class CancelWishlistModel implements CancelWishlistContract.Model {
    private CancelWishlistRepository wishlistRepository;

    public CancelWishlistModel(CancelWishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public Observable<BaseResponseEntity> cancelWishtlist(String productId) {
        return wishlistRepository.cancelWishList(productId);
    }


}
