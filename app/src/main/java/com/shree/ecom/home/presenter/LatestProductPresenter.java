package com.shree.ecom.home.presenter;

import com.shree.ecom.home.contract.LatestProductContract;
import com.shree.ecom.home.model.dto.LatestProductEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LatestProductPresenter implements LatestProductContract.Presenter {

    private LatestProductContract.View view;
    private Disposable disposable;
    private LatestProductContract.Model model;

    public LatestProductPresenter(LatestProductContract.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        if (view != null) {
            view.progressOn(true);
            disposable = model
                    .getProduct()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<LatestProductEntity>() {
                        @Override
                        public void onNext(LatestProductEntity latestProductEntity) {
                            view.progressOn(false);
                            view.updateData(latestProductEntity.getData().getProducts());
                        }

                        @Override
                        public void onError(Throwable e) {
                            view.progressOn(false);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }

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
    public void setView(LatestProductContract.View view) {
        this.view = view;
    }
}
