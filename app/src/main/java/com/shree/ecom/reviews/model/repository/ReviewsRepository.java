package com.shree.ecom.reviews.model.repository;

import com.shree.ecom.reviews.model.dto.ReviewsEntity;
import com.shree.ecom.reviews.model.dto.ReviewsResponseEntity;

import io.reactivex.Observable;

public interface ReviewsRepository {
    Observable<ReviewsEntity> getReviewsFromNetwork(String id);

    Observable<ReviewsEntity> getReviewsFromCache();

    Observable<ReviewsEntity> getReviews(String id);

    Observable<ReviewsResponseEntity> postReview(int productId, int star, String comment);

}
