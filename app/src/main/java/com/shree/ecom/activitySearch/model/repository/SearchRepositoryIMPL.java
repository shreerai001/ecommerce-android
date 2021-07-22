package com.shree.ecom.activitySearch.model.repository;

import com.shree.ecom.activitySearch.model.dto.SearchResponseEntity;
import com.shree.ecom.activitySearch.service.SearchApiService;

import io.reactivex.Observable;

public class SearchRepositoryIMPL implements SearchRepository {
    private SearchApiService searchApiService;

    public SearchRepositoryIMPL(SearchApiService searchApiService) {
        this.searchApiService = searchApiService;
    }

    @Override
    public Observable<SearchResponseEntity> search(String productName) {
        return searchApiService.getSearchResponse(productName);
    }
}
