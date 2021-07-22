package com.shree.ecom.reviews.model;

import android.content.Context;

import com.shree.ecom.reviews.contract.ReviewsContract;
import com.shree.ecom.reviews.model.dto.ReviewsEntity;
import com.shree.ecom.reviews.model.dto.ReviewsResponseEntity;
import com.shree.ecom.reviews.model.repository.ReviewsRepository;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;

import io.reactivex.Observable;

public class ReviewsModel extends BaseRepositoryIMPL implements ReviewsContract.Model {

    private ReviewsRepository reviewsRepository;
    private Context context;

    public ReviewsModel(Context context, ReviewsRepository reviewsRepository) {
        super(context);
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public Observable<ReviewsEntity> getReviews(String id) {
        return reviewsRepository.getReviews(id);
    }

    @Override
    public Observable<ReviewsResponseEntity> postReviews(int id, int star, String comment) {
        return reviewsRepository.postReview(id, star, comment);
    }

    @Override
    public boolean checkLoggedIn() {
        return super.checkdLoggedIn();
    }
}
