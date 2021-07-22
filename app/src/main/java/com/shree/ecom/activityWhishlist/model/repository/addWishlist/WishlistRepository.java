package com.shree.ecom.activityWhishlist.model.repository.addWishlist;

import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface WishlistRepository {
    Observable<BaseResponseEntity> addToWishList(String productId);
}
