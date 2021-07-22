package com.shree.ecom.activityBrowse.view.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shree.ecom.R;
import com.shree.ecom.activityBrowse.contract.NewProductContract;
import com.shree.ecom.activityBrowse.model.dto.newProducts.NewProductDataDto;
import com.shree.ecom.activityBrowse.view.adapter.NewEquipmentAdapter;
import com.shree.ecom.activityWhishlist.contract.WishlistContract;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.ProgressUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewEquipmentActivity extends AppCompatActivity implements NewProductContract.View, WishlistContract.View {

    @Inject
    NewProductContract.Presenter presenter;

    @BindView(R.id.newEquipment_recycler)
    RecyclerView newEquipmentRecycler_v;
    private Unbinder unbinder_deo;

    @Inject
    WishlistContract.Presenter presenterWishlist;
    private ProgressDialog progressDialog;

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadData();
    }

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_new_equipment, container, false);
//        unbinder_deo = ButterKnife.bind(this, view);
//        ((App) getActivity().getApplication()).getComponent().inject(this);
//        presenter.setView(this);
//        presenterWishlist.setView(this);
//        return view;
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_equipment);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        presenterWishlist.setView(this);
    }

    @Override
    public void loadData(List<NewProductDataDto> newProductDataDtoList) {
        NewEquipmentAdapter allEquipmentAdapter = new NewEquipmentAdapter(newProductDataDtoList, getApplicationContext(), this);
        newEquipmentRecycler_v.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        newEquipmentRecycler_v.setHasFixedSize(false);
        newEquipmentRecycler_v.setAdapter(allEquipmentAdapter);
    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void displayTransferMessage(String message) {

    }

    @Override
    public void progressOn(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(NewEquipmentActivity.this);
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
