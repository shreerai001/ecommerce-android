package com.shree.ecom.home.presenter;

import android.util.Log;
import android.widget.Toast;

import com.shree.ecom.home.contract.FeaturedProductContract;
import com.shree.ecom.home.model.dto.FeaturedProductEntity;
import com.shree.ecom.utils.values.CONST;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class FeaturedProductPresenter implements FeaturedProductContract.Presenter {

    private FeaturedProductContract.View view;
    private Disposable disposable;
    private FeaturedProductContract.Model model;

    public FeaturedProductPresenter(FeaturedProductContract.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        if (view != null) {
            view.showLoading(true);
        }
        disposable = model
                .getFeaturedProduct()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<FeaturedProductEntity>() {
                    @Override
                    public void onNext(FeaturedProductEntity featuredProductEntity) {
                        if (view != null) {
                            view.showLoading(false);
                        }
                        view.updateFeaturedData(featuredProductEntity.getData().getFeaturedProductEntity());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(FeaturedProductPresenter.class.toString(), e.getLocalizedMessage());
                        view.offlineActivity();
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
    public void setView(FeaturedProductContract.View view) {
        this.view = view;
    }
}
