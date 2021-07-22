package com.shree.ecom.similarProducts.presenter;

import android.content.Context;

import com.shree.ecom.similarProducts.contract.SimilarProductsContract;
import com.shree.ecom.similarProducts.model.dto.SimilarProductsEntity;
import com.shree.ecom.utils.values.NetworkUtils;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class SimilarProductsPresenter implements SimilarProductsContract.Presenter {

    private SimilarProductsContract.View view;
    private SimilarProductsContract.Model model;
    private Disposable disposable;
    private Context context;

    public SimilarProductsPresenter(SimilarProductsContract.Model model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public void setView(SimilarProductsContract.View view) {
        this.view = view;
    }

    @Override
    public void loadSimilarProducts(String id) {
        if (NetworkUtils.isNetworkConnected(context)) {
            disposable = model
                    .getSimilarProducts(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<SimilarProductsEntity>>() {
                        @Override
                        public void onNext(List<SimilarProductsEntity> similarProductsEntities) {
                            if (view != null)
                                view.loadSimilarProducts(similarProductsEntities);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    @Override
    public void loadData() {

    }

    @Override
    public void rxUnsuscribe() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
