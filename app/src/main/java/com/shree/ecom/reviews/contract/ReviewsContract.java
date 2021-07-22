package com.shree.ecom.reviews.contract;

import com.shree.ecom.reviews.model.dto.ReviewsDataDto;
import com.shree.ecom.reviews.model.dto.ReviewsEntity;
import com.shree.ecom.reviews.model.dto.ReviewsResponseEntity;
import com.shree.ecom.utils.mvp.BasePresenter;
import com.shree.ecom.utils.mvp.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface ReviewsContract {
    interface View extends BaseView {
        void loadReviews(List<ReviewsDataDto> reviewsEntityList);
    }

    interface Presenter extends BasePresenter {
        void setView(ReviewsContract.View view);

        void postReviews(int id, int star, String comment);

        void loadData(String id);
    }

    interface Model {
        Observable<ReviewsEntity> getReviews(String id);

        Observable<ReviewsResponseEntity> postReviews(int id, int star, String comment);

        boolean checkLoggedIn();
    }

}
