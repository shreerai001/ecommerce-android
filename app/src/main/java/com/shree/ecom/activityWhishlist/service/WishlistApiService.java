package com.shree.ecom.activityWhishlist.service;

import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface WishlistApiService {


    @POST("my-account/wishlist")
    @FormUrlEncoded
    Observable<BaseResponseEntity> addToWishlist(
            @Header("Authorization") String auth,
            @Field("product_id") String product_id);


}
