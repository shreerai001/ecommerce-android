package com.shree.ecom.activitySearch.service;

import com.shree.ecom.activitySearch.model.dto.SearchResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchApiService {
    @GET("search")
    Observable<SearchResponseEntity> getSearchResponse(@Query("q") String shree);
}
