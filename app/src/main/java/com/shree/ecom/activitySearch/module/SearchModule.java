package com.shree.ecom.activitySearch.module;

import com.shree.ecom.activitySearch.model.SearchModel;
import com.shree.ecom.activitySearch.contract.SearchContract;
import com.shree.ecom.activitySearch.model.repository.SearchRepository;
import com.shree.ecom.activitySearch.model.repository.SearchRepositoryIMPL;
import com.shree.ecom.activitySearch.presenter.SearchPresenter;
import com.shree.ecom.activitySearch.service.SearchApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {
    @Provides
    public SearchContract.Model providesModel(SearchRepository searchRepository) {
        return new SearchModel(searchRepository);
    }

    @Provides
    public SearchContract.Presenter providesPresenter(SearchContract.Model model) {
        return new SearchPresenter(model);
    }

    @Provides
    @Singleton
    public SearchRepository providesRespo(SearchApiService searchApiService) {
        return new SearchRepositoryIMPL(searchApiService);
    }
}
