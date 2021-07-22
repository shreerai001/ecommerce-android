package com.shree.ecom.activitySearch.model.repository;

import com.shree.ecom.activitySearch.model.dto.SearchResponseEntity;

import io.reactivex.Observable;

public interface SearchRepository {
    Observable<SearchResponseEntity> search(String productName);
}
