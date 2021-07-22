package com.shree.ecom.activityProductDetail.presenter;

import com.shree.ecom.activityProductDetail.contract.ProductDetailContract;
import com.shree.ecom.activityProductDetail.model.dto.ProductDetailEntity;
import com.shree.ecom.activityProductDetail.model.dto.ProductRecommendationDataDto;
import com.shree.ecom.activityProductDetail.model.dto.ProductRecommendationEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ProductDetailPresenter implements ProductDetailContract.Presenter {

    private ProductDetailContract.Model model;
    private ProductDetailContract.View view;
    private Disposable disposable;

    public ProductDetailPresenter(ProductDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(ProductDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void addProductToCart(ProductDetailEntity productDetailEntity) {
        if (model.addProductToCart(productDetailEntity)) {
            view.displayMessage("Product added to cart");
        } else {
            view.displayMessage("Product already exist on cart");
        }
    }

    @Override
    public void loadData() {
        if (view != null) {
            view.progressOn(true);
            disposable = model.getProductRecommendation()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<ProductRecommendationEntity>() {
                        @Override
                        public void onNext(ProductRecommendationEntity productRecommendationEntity) {
                            view.progressOn(false);
                            List<ProductRecommendationDataDto> productRecommendationDataDto = new ArrayList<>();
                            productRecommendationDataDto.add(productRecommendationEntity.getData());
                            view.loadProductRecommendataion(productRecommendationDataDto);
                        }

                        @Override
                        public void onError(Throwable e) {
                            view.progressOn(false);
                            view.displayMessage(e.getMessage());
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
}
