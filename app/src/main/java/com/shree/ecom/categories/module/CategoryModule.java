package com.shree.ecom.categories.module;

import com.shree.ecom.categories.contract.CategoriesContract;
import com.shree.ecom.categories.model.CategoryModel;
import com.shree.ecom.categories.presenter.CategoriesPresenter;
import com.shree.ecom.categories.model.repository.CategoryRepository;
import com.shree.ecom.categories.model.repository.CategoryRepositoryIMPL;
import com.shree.ecom.categories.services.CategoryApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryModule {

    @Provides
    public CategoriesContract.Model provideModel(CategoryRepository categoryRepository) {
        return new CategoryModel(categoryRepository);
    }

    @Provides
    public CategoriesContract.Presenter providePresenter(CategoriesContract.Model model) {
        return new CategoriesPresenter(model);
    }


    @Singleton
    @Provides
    public CategoryRepository provideRepository(CategoryApiService categoryApiService) {
        return new CategoryRepositoryIMPL(categoryApiService);
    }
}
