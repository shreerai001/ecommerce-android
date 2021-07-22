package com.shree.ecom.activityWhishlist.module.showWishlist;

import android.content.Context;

import com.shree.ecom.activityWhishlist.contract.MyWishlistContract;
import com.shree.ecom.activityWhishlist.model.MyWishlistModel;
import com.shree.ecom.activityWhishlist.model.repository.showWishlist.MyWishlistRepository;
import com.shree.ecom.activityWhishlist.model.repository.showWishlist.MyWishlistRepositoryIMPL;
import com.shree.ecom.activityWhishlist.presenter.MyWishtlistPresenter;
import com.shree.ecom.activityWhishlist.service.MyWishlistApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyWishlistModule {

    @Provides
    public MyWishlistContract.Presenter providePresenter(Context context, MyWishlistContract.Model model) {
        return new MyWishtlistPresenter(context, model);
    }

    @Provides
    public MyWishlistContract.Model provideModel(MyWishlistRepository wishlistRepository) {
        return new MyWishlistModel(wishlistRepository);
    }

    @Provides
    @Singleton
    public MyWishlistRepository provideRepository(Context context, MyWishlistApiService wishlistApiService) {
        return new MyWishlistRepositoryIMPL(context, wishlistApiService);
    }
}
