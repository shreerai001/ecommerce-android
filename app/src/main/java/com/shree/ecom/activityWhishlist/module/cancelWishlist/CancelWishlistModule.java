package com.shree.ecom.activityWhishlist.module.cancelWishlist;

import android.content.Context;

import com.shree.ecom.activityWhishlist.contract.CancelWishlistContract;
import com.shree.ecom.activityWhishlist.model.CancelWishlistModel;
import com.shree.ecom.activityWhishlist.model.repository.cancelWishlist.CancelWishlistRepository;
import com.shree.ecom.activityWhishlist.model.repository.cancelWishlist.CancelWishlistRepositoryIMPL;
import com.shree.ecom.activityWhishlist.presenter.CancelWishlistPresenter;
import com.shree.ecom.activityWhishlist.service.CancelWishlistApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CancelWishlistModule {

    @Provides
    public CancelWishlistContract.Presenter providePresenter(CancelWishlistContract.Model model, Context context) {
        return new CancelWishlistPresenter(model, context);
    }

    @Provides
    public CancelWishlistContract.Model provideModel(CancelWishlistRepository wishlistRepository) {
        return new CancelWishlistModel(wishlistRepository);
    }

    @Provides
    @Singleton
    public CancelWishlistRepository provideRepository(Context context, CancelWishlistApiService wishlistApiService) {
        return new CancelWishlistRepositoryIMPL(context, wishlistApiService);
    }
}
