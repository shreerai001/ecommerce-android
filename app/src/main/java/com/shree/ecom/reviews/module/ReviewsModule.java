package com.shree.ecom.reviews.module;

import android.content.Context;

import com.shree.ecom.reviews.contract.ReviewsContract;
import com.shree.ecom.reviews.model.ReviewsModel;
import com.shree.ecom.reviews.model.repository.ReviewsRepository;
import com.shree.ecom.reviews.model.repository.ReviewsRepositoryIMPL;
import com.shree.ecom.reviews.presenter.ReviewsPresenter;
import com.shree.ecom.reviews.service.ReviewsApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ReviewsModule {
    @Provides
    public ReviewsContract.Model provideModel(Context context, ReviewsRepository reviewsRepository) {
        return new ReviewsModel(context, reviewsRepository);
    }

    @Provides
    public ReviewsContract.Presenter providePresenter(ReviewsContract.Model model,Context context) {
        return new ReviewsPresenter(model,context);
    }

    @Provides
    @Singleton
    public ReviewsRepository provideRepository(Context context, ReviewsApiService reviewsApiService) {
        return new ReviewsRepositoryIMPL(reviewsApiService, context);
    }
}
