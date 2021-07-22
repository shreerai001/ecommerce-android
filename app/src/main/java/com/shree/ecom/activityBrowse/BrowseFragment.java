package com.shree.ecom.activityBrowse;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.activityBrowse.view.activity.AllEquipmentProductActivity;
import com.shree.ecom.activityBrowse.view.activity.NewEquipmentActivity;
import com.shree.ecom.activityBrowse.view.activity.RentalEquipmentActivity;
import com.shree.ecom.activityBrowse.view.activity.UsedEquipmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class BrowseFragment extends Fragment {

    @BindView(R.id.all_shop)
    TextView allShop;

    @BindView(R.id.new_shop)
    TextView newShop;

    @BindView(R.id.used_shop)
    TextView usedShop;

    @BindView(R.id.rental_shop)
    TextView rentalShop;

    private Unbinder unbinder_deo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shop, container, false);
        unbinder_deo = ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.all_shop)
    void onAllItemClicked() {
        Toast.makeText(getActivity(), "All", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getActivity(), AllEquipmentProductActivity.class));
    }

    @OnClick(R.id.new_shop)
    void onNewItemClicked() {
        Toast.makeText(getActivity(), "new", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getActivity(), NewEquipmentActivity.class));
    }

    @OnClick(R.id.used_shop)
    void onUsedItemClicked() {
        Toast.makeText(getActivity(), "used", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getActivity(), UsedEquipmentActivity.class));
    }

    @OnClick(R.id.rental_shop)
    void onRentalItemClicked() {
        Toast.makeText(getActivity(), "rental", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getActivity(), RentalEquipmentActivity.class));
    }
}
