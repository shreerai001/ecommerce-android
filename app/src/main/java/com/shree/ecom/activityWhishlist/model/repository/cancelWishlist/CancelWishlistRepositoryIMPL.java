package com.shree.ecom.activityWhishlist.model.repository.cancelWishlist;

import android.content.Context;

import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;
import com.shree.ecom.utils.values.BaseResponseEntity;
import com.shree.ecom.activityWhishlist.model.dto.WishlistEntity;
import com.shree.ecom.activityWhishlist.service.CancelWishlistApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class CancelWishlistRepositoryIMPL extends BaseRepositoryIMPL implements CancelWishlistRepository {
    private CancelWishlistApiService wishlistApiService;
    private Context context;
    private long timeStamp;
    private List<WishlistEntity> wishlistEntityList;


    public CancelWishlistRepositoryIMPL(Context context, CancelWishlistApiService wishlistApiService) {
        super(context);
        this.context = context;
        this.wishlistApiService = wishlistApiService;
        wishlistEntityList = new ArrayList<>();
        this.timeStamp = System.currentTimeMillis();
    }

    @Override
    public Observable<BaseResponseEntity> cancelWishList(String productId) {
        return wishlistApiService.cancelWishlist("Bearer " + accessToken(context), productId);
    }


}
