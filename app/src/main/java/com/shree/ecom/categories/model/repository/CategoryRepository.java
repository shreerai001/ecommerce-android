package com.shree.ecom.categories.model.repository;

import com.shree.ecom.categories.model.dto.CategoryDto;

import io.reactivex.Observable;

public interface CategoryRepository {

    Observable<CategoryDto> getCategory();

    Observable<CategoryDto> getCategoryFromNetwork();

    Observable<CategoryDto> getCategoryFromCache();

}
