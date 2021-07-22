package com.shree.ecom.activityWhishlist.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.shree.ecom.R;
import com.shree.ecom.activityBrowse.view.activity.AllEquipmentProductActivity;
import com.shree.ecom.activityLogin.LoginActivity;
import com.shree.ecom.activityWhishlist.contract.CancelWishlistContract;
import com.shree.ecom.activityWhishlist.service.Cancel;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.activityWhishlist.contract.MyWishlistContract;
import com.shree.ecom.activityWhishlist.model.dto.WishlistDataEntity;
import com.shree.ecom.utils.values.CONST;
import com.shree.ecom.utils.values.ProgressUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This activity displays wishlist products
 */
public class WishlistActivity extends AppCompatActivity implements
        CancelWishlistContract.View,
        MyWishlistContract.View, Cancel {


    @BindView(R.id.wishlist_recycler)
    RecyclerView recyclerViewWishlist_v;

    @Inject
    MyWishlistContract.Presenter presenter;

    @Inject
    CancelWishlistContract.Presenter cancelWishlistPresenter;

    @BindView(R.id.wishlist_progress)
    ProgressBar wishlistProgress;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        ButterKnife.bind(this);
        ((App) getApplicationContext()).getComponent().inject(this);
        presenter.setView(this);
        progressOn(true);
        cancelWishlistPresenter.setView(this);
        presenter.loadData();
    }


    @Override
    public void lodaData(List<WishlistDataEntity> wishlistDataEntityList) {
        progressOn(false);
        if (wishlistDataEntityList.size() == 0) {
            Snackbar.make(recyclerViewWishlist_v, CONST.NULL_CART, Snackbar.LENGTH_LONG).show();
        }
        MyWishlistAdapter myWishlistAdapter = new MyWishlistAdapter(wishlistDataEntityList, getApplicationContext(), this);
        recyclerViewWishlist_v.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        recyclerViewWishlist_v.setAdapter(myWishlistAdapter);
        recyclerViewWishlist_v.setHasFixedSize(false);
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(recyclerViewWishlist_v, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void displayTransferMessage(String message) {

    }

    @Override
    public void progressOn(boolean progressState) {
        if (progressState) {
            progressDialog = ProgressUtils.showProgressDialog(WishlistActivity.this);
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
        // wishlistProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void stop() {
        wishlistProgress.setVisibility(View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter.checkdLoggedIn()) {
            presenter.loadData();
        } else {
            startActivity(new Intent(WishlistActivity.this, LoginActivity.class));
        }
    }

    @Override
    public void cancelWishList(String productId) {
        cancelWishlistPresenter.cancelWishList(productId);
        onStart();
    }

}
