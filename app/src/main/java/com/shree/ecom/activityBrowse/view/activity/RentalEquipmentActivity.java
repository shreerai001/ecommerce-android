package com.shree.ecom.activityBrowse.view.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.activityBrowse.contract.RentalContract;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalCartDto;
import com.shree.ecom.activityBrowse.model.dto.rental.RentalDataDto;
import com.shree.ecom.activityBrowse.view.adapter.RentalAdapter;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.activityWhishlist.contract.WishlistContract;
import com.shree.ecom.utils.values.ProgressUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RentalEquipmentActivity extends AppCompatActivity implements RentalContract.View, WishlistContract.View {
    @BindView(R.id.fragment_rental_equipment)
    RelativeLayout relativeLayout;

    @BindView(R.id.recycler_rental)
    RecyclerView rentalRecyclerView_v;

    @Inject
    RentalContract.Presenter presenter;

    @Inject
    WishlistContract.Presenter presenterWishlist;

    private Unbinder unbinder_deo;
    private ProgressDialog progressDialog;

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadData();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_equipment);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        presenterWishlist.setView(this);
    }


    @Override
    public void displayMessage(String message) {
        Snackbar.make(relativeLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void displayTransferMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void progressOn(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(RentalEquipmentActivity.this);
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void loadData(List<RentalDataDto> rentalDataDtoList) {
        RentalAdapter rentalAdapter = new RentalAdapter(rentalDataDtoList, getApplicationContext(), RentalEquipmentActivity.this);
        rentalRecyclerView_v.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        rentalRecyclerView_v.setHasFixedSize(false);
        rentalRecyclerView_v.setAdapter(rentalAdapter);
    }

    @Override
    public void addRentalCart(RentalCartDto rentalCartDto) {
        presenter.addRentalCart(rentalCartDto);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.rxUnsuscribe();
    }


    @Override
    public void addToWishlist(String productId) {
        presenterWishlist.addToWishlist(productId);
    }


}
