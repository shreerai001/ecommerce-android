package com.shree.ecom.activitySearch.model;

import com.shree.ecom.activitySearch.contract.SearchContract;
import com.shree.ecom.activitySearch.model.dto.SearchResponseEntity;
import com.shree.ecom.activitySearch.model.repository.SearchRepository;

import io.reactivex.Observable;

public class SearchModel implements SearchContract.Model {

    private SearchRepository searchRepository;

    public SearchModel(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public Observable<SearchResponseEntity> searchProduct(String productName) {
        return searchRepository.search(productName);
    }
}
