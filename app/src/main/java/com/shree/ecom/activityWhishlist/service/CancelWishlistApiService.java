package com.shree.ecom.activityWhishlist.service;

import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface CancelWishlistApiService {


    @GET("my-account/wishlist/{id}")
    Observable<BaseResponseEntity> cancelWishlist(
            @Header("Authorization") String auth,
            @Path("id") String product_id);


}
