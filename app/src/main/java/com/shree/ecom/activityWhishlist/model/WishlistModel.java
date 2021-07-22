package com.shree.ecom.activityWhishlist.model;

import com.shree.ecom.activityWhishlist.contract.WishlistContract;
import com.shree.ecom.activityWhishlist.model.repository.addWishlist.WishlistRepository;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class WishlistModel implements WishlistContract.Model {
    private WishlistRepository wishlistRepository;

    public WishlistModel(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public Observable<BaseResponseEntity> addToWishlist(String productId) {
        return wishlistRepository.addToWishList(productId);
    }
}
