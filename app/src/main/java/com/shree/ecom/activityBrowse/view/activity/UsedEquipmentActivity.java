package com.shree.ecom.activityBrowse.view.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.shree.ecom.R;
import com.shree.ecom.activityBrowse.contract.UsedProductContract;
import com.shree.ecom.activityBrowse.model.dto.used.UsedProductDataDto;
import com.shree.ecom.activityBrowse.view.adapter.UsedEquipmentAdapter;
import com.shree.ecom.activityWhishlist.contract.WishlistContract;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.ProgressUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class UsedEquipmentActivity extends AppCompatActivity implements UsedProductContract.View, WishlistContract.View {

    @BindView(R.id.used_recycler)
    RecyclerView recyclerViewUsed_v;

    @BindView(R.id.usedFrame)
    FrameLayout usedFrameLayout_v;

    @Inject
    UsedProductContract.Presenter presenter;

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
        setContentView(R.layout.activity_used_equipment);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);

    }

    @Override
    public void loadData(List<UsedProductDataDto> usedProductDataDtos) {
        UsedEquipmentAdapter usedEquipmentAdapter = new UsedEquipmentAdapter(usedProductDataDtos, getApplicationContext(), this);
        recyclerViewUsed_v.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerViewUsed_v.setHasFixedSize(false);
        recyclerViewUsed_v.setAdapter(usedEquipmentAdapter);
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(usedFrameLayout_v, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.rxUnsuscribe();
    }

    @Override
    public void displayTransferMessage(String message) {

    }

    @Override
    public void progressOn(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(UsedEquipmentActivity.this);
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
    public void addToWishlist(String productId) {
        presenterWishlist.addToWishlist(productId);
    }
}
