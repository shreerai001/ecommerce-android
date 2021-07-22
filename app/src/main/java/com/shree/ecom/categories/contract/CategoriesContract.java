package com.shree.ecom.categories.contract;

import com.shree.ecom.categories.model.dto.CategoryDto;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface CategoriesContract {

    interface View extends BaseView {
        void updateCategories(CategoryDto categoryDtoList);

    }

    interface Presenter extends BasePresenter {

        void setView(CategoriesContract.View view);
    }

    interface Model {
        Observable<CategoryDto> getCategories();
    }
}
