package com.shree.ecom.activityWhishlist.model.repository.addWishlist;

import android.content.Context;

import com.shree.ecom.activityWhishlist.service.WishlistApiService;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;
import com.shree.ecom.utils.values.BaseResponseEntity;

import io.reactivex.Observable;

public class WishlistRepositoryIMPL extends BaseRepositoryIMPL implements WishlistRepository {

    private WishlistApiService wishlistApiService;
    private Context context;

    public WishlistRepositoryIMPL(Context context, WishlistApiService wishlistApiService) {
        super(context);
        this.context = context;
        this.wishlistApiService = wishlistApiService;

    }

    @Override
    public Observable<BaseResponseEntity> addToWishList(String productId) {
        return wishlistApiService.addToWishlist("Bearer " + accessToken(context), productId);
    }
}
