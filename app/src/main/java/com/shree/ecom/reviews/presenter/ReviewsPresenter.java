package com.shree.ecom.reviews.presenter;

import android.content.Context;

import com.shree.ecom.reviews.contract.ReviewsContract;
import com.shree.ecom.reviews.model.dto.ReviewsDataDto;
import com.shree.ecom.reviews.model.dto.ReviewsEntity;
import com.shree.ecom.reviews.model.dto.ReviewsResponseEntity;
import com.shree.ecom.utils.values.CONST;
import com.shree.ecom.utils.values.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ReviewsPresenter implements ReviewsContract.Presenter {
    private ReviewsContract.Model model;
    private Disposable disposable;
    private ReviewsContract.View view;
    private Context context;

    public ReviewsPresenter(ReviewsContract.Model model, Context context) {

        this.model = model;
        this.context = context;
    }


    @Override
    public void loadData(String id) {
        if (NetworkUtils.isNetworkConnected(context)) {
            disposable = model
                    .getReviews(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            new Consumer<ReviewsEntity>() {
                                @Override
                                public void accept(ReviewsEntity reviewsEntity) throws Exception {
                                    if (view != null) {
                                        List<ReviewsDataDto> reviewsDataDtoArrayList = new ArrayList<>();
                                        for (int i = 0; i < reviewsEntity.getData().size(); i++) {
                                            reviewsDataDtoArrayList.add(reviewsEntity.getData().get(i));
                                        }
                                        view.loadReviews(reviewsDataDtoArrayList);
                                    } else {
                                        view.displayMessage(CONST.NETWORK_FETCH_ERROR);
                                    }
                                }

                            }
                    );
        } else if (view != null) {
            view.displayTransferMessage("No Internet Connection");
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

    @Override
    public void setView(ReviewsContract.View view) {
        this.view = view;
    }

    @Override
    public void postReviews(int id, int star, String comment) {
        if (model.checkLoggedIn()) {
            disposable = model.postReviews(id, star, comment)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            new Consumer<ReviewsResponseEntity>() {
                                @Override
                                public void accept(ReviewsResponseEntity reviewsResponseEntity) throws Exception {
                                    view.displayMessage(CONST.SUCCED);
                                }
                            }
                    );
        } else {
            view.displayMessage("You have to logged in to rate product");
        }
    }

}
