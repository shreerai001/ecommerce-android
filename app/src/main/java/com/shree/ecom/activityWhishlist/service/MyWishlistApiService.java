package com.shree.ecom.activityWhishlist.service;

import com.shree.ecom.activityWhishlist.model.dto.WishlistEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface MyWishlistApiService {

    @GET("my-account/wishlists")
    Observable<WishlistEntity> getWishlist(
            @Header("Authorization") String auth);


}
