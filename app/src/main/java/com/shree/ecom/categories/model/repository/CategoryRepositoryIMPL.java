package com.shree.ecom.categories.model.repository;

import com.shree.ecom.categories.model.dto.CategoryDto;
import com.shree.ecom.categories.services.CategoryApiService;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class CategoryRepositoryIMPL implements CategoryRepository {

    private CategoryApiService categoryApiService;
    List<CategoryDto> categoryDtoList;
    private long timeStamp;

    public CategoryRepositoryIMPL(CategoryApiService categoryApiService) {
        this.categoryApiService = categoryApiService;
        this.timeStamp = System.currentTimeMillis();
        categoryDtoList = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<CategoryDto> getCategory() {
        return getCategoryFromCache().switchIfEmpty(getCategoryFromNetwork());
    }

    @Override
    public Observable<CategoryDto> getCategoryFromNetwork() {
        return categoryApiService.getCategory();
    }

    @Override
    public Observable<CategoryDto> getCategoryFromCache() {
        if (isUpToDate()) {
            return Observable.fromIterable(categoryDtoList);
        } else {
            timeStamp = System.currentTimeMillis();
            categoryDtoList.clear();
            return Observable.empty();
        }
    }
}
