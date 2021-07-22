package com.shree.ecom.categories.model;

import com.shree.ecom.categories.contract.CategoriesContract;
import com.shree.ecom.categories.model.dto.CategoryDto;
import com.shree.ecom.categories.model.repository.CategoryRepository;

import io.reactivex.Observable;

public class CategoryModel implements CategoriesContract.Model {

    private CategoryRepository categoryRepository;

    public CategoryModel(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Observable<CategoryDto> getCategories() {
        return categoryRepository.getCategory();
    }
}
