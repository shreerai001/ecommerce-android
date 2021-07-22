package com.shree.ecom.activityBrowse.view.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.activityBrowse.contract.AllProductContract;
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductDto;
import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductEntity;
import com.shree.ecom.activityBrowse.view.adapter.AllEquipmentAdapter;
import com.shree.ecom.activityWhishlist.contract.WishlistContract;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.ProgressUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AllEquipmentProductActivity extends AppCompatActivity implements AllProductContract.View, WishlistContract.View {

    @BindView(R.id.frame_layout_all)
    LinearLayout linearLayout;

    @BindView(R.id.recycler_all_product)
    RecyclerView recyclerView_v;

    @Inject
    AllProductContract.Presenter presenter;

    @Inject
    WishlistContract.Presenter presenterWishlist;
    private ProgressDialog progressDialog;


    @Override
    public void onStart() {
        super.onStart();
        presenter.loadData();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_equipment);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        presenterWishlist.setView(this);
    }

    @Override
    public void loadData(List<AllEquipmentProductDto> equipmentEntityList) {
        AllEquipmentAdapter allEquipmentAdapter = new AllEquipmentAdapter(equipmentEntityList, getApplicationContext(), this);
        recyclerView_v.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView_v.setHasFixedSize(false);
        recyclerView_v.setAdapter(allEquipmentAdapter);
    }

    @Override
    public void addRentalCart(AllEquipmentProductEntity allEquipmentProductEntity) {
        presenter.addAllProductToCart(allEquipmentProductEntity);
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(linearLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void displayTransferMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void progressOn(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(AllEquipmentProductActivity.this);
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
    public void onDestroy() {
        super.onDestroy();
        presenter.rxUnsuscribe();
    }



    @Override
    public void addToWishlist(String productId) {
        presenterWishlist.addToWishlist(productId);
    }
}
