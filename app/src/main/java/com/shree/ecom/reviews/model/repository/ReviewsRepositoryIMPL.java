package com.shree.ecom.reviews.model.repository;

import android.content.Context;

import com.shree.ecom.reviews.model.dto.ReviewsEntity;
import com.shree.ecom.reviews.model.dto.ReviewsResponseEntity;
import com.shree.ecom.reviews.service.ReviewsApiService;
import com.shree.ecom.utils.mvp.BaseRepository;
import com.shree.ecom.utils.values.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class ReviewsRepositoryIMPL extends BaseRepository implements ReviewsRepository {
    private ReviewsApiService reviewsApiService;
    private List<ReviewsEntity> reviewsEntityList;
    private long timeStamp;
    private Context context;

    public ReviewsRepositoryIMPL(ReviewsApiService reviewsApiService, Context context) {
        this.reviewsApiService = reviewsApiService;
        this.timeStamp = System.currentTimeMillis();
        reviewsEntityList = new ArrayList<>();
        this.context = context;
    }


    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<ReviewsEntity> getReviewsFromNetwork(String id) {
        return reviewsApiService.getReviews(id);
    }

    @Override
    public Observable<ReviewsEntity> getReviewsFromCache() {
        if (isUpToDate()) {
            return Observable.fromIterable(reviewsEntityList);
        } else {
            timeStamp = System.currentTimeMillis();
            reviewsEntityList.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<ReviewsEntity> getReviews(String id) {
        return getReviewsFromCache().switchIfEmpty(getReviewsFromNetwork(id));
    }

    @Override
    public Observable<ReviewsResponseEntity> postReview(int productId, int star, String comment) {
        return reviewsApiService.postReviews("Bearer " + accessToken(context), productId, star, comment);
    }

    @Override
    public boolean checkdLoggedIn() {
        return false;
    }
}
