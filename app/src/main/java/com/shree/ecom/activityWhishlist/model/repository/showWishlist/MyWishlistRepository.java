package com.shree.ecom.activityWhishlist.model.repository.showWishlist;

import com.shree.ecom.activityWhishlist.model.dto.WishlistEntity;

import io.reactivex.Observable;

public interface MyWishlistRepository {

    Observable<WishlistEntity> getWishlistFromNetwork();

    Observable<WishlistEntity> getWishlist();

    Observable<WishlistEntity> getWishlistFromCache();
}
