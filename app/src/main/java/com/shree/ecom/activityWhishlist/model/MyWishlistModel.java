package com.shree.ecom.activityWhishlist.model;

import com.shree.ecom.activityWhishlist.contract.MyWishlistContract;
import com.shree.ecom.activityWhishlist.model.dto.WishlistEntity;
import com.shree.ecom.activityWhishlist.model.repository.showWishlist.MyWishlistRepository;

import io.reactivex.Observable;

public class MyWishlistModel implements MyWishlistContract.Model {
    private MyWishlistRepository myWishlistRepository;

    public MyWishlistModel(MyWishlistRepository myWishlistRepository) {
        this.myWishlistRepository = myWishlistRepository;
    }


    @Override
    public Observable<WishlistEntity> getWishList() {
        return myWishlistRepository.getWishlist();
    }
}
