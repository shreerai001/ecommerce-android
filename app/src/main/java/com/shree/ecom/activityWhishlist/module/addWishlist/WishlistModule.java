package com.shree.ecom.activityWhishlist.module.addWishlist;

import android.content.Context;

import com.shree.ecom.activityWhishlist.contract.WishlistContract;
import com.shree.ecom.activityWhishlist.model.WishlistModel;
import com.shree.ecom.activityWhishlist.model.repository.addWishlist.WishlistRepository;
import com.shree.ecom.activityWhishlist.model.repository.addWishlist.WishlistRepositoryIMPL;
import com.shree.ecom.activityWhishlist.presenter.WishlistPresenter;
import com.shree.ecom.activityWhishlist.service.WishlistApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class WishlistModule {

    @Provides
    public WishlistContract.Presenter providePresenter(WishlistContract.Model model, Context context) {
        return new WishlistPresenter(model, context);
    }

    @Provides
    public WishlistContract.Model provideModel(WishlistRepository wishlistRepository) {
        return new WishlistModel(wishlistRepository);
    }

    @Singleton
    @Provides
    public WishlistRepository provideRepository(Context context, WishlistApiService wishlistApiService) {
        return new WishlistRepositoryIMPL(context, wishlistApiService);
    }
}
