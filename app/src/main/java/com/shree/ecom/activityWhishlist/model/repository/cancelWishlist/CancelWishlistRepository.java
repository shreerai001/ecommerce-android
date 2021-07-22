package com.shree.ecom.activityWhishlist.model.repository.cancelWishlist;

import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public interface CancelWishlistRepository {
    Observable<BaseResponseEntity> cancelWishList(String productId);
}
