package com.shree.ecom.categories.presenter;

import com.shree.ecom.categories.contract.CategoriesContract;
import com.shree.ecom.categories.model.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CategoriesPresenter implements CategoriesContract.Presenter {

    private CategoriesContract.Model model;
    private Disposable disposable;
    private CategoriesContract.View view;

    public CategoriesPresenter(CategoriesContract.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        disposable = model
                .getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<CategoryDto>() {
                    @Override
                    public void onNext(CategoryDto categoryDto) {
                        if (view != null) {
                            view.updateCategories(categoryDto);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void rxUnsuscribe() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }

    @Override
    public void setView(CategoriesContract.View view) {
        this.view = view;
    }
}
