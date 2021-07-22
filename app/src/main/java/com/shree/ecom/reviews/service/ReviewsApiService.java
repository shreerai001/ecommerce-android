package com.shree.ecom.reviews.service;

import com.shree.ecom.reviews.model.dto.ReviewsEntity;
import com.shree.ecom.reviews.model.dto.ReviewsResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ReviewsApiService {
    @GET("review/{id}")
    Observable<ReviewsEntity> getReviews(@Path("id") String id);

    @FormUrlEncoded
    @POST("review")
    Observable<ReviewsResponseEntity> postReviews(
            @Header("Authorization") String auth,
            @Field("product_id") int productId,
            @Field("star") int star,
            @Field("comment") String comment);
}
