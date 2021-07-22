package com.shree.ecom.similarProducts.service;

import com.shree.ecom.similarProducts.model.dto.SimilarProductsEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface SimilarProductsApiService {
    @GET("similar-products/{id}")
    Observable<List<SimilarProductsEntity>> getSimilarProducts(@Header("Authorization") String auth,
                                                               @Path("id") String id);

}
