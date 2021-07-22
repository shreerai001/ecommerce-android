package com.shree.ecom.buySell.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shree.ecom.R;
import com.shree.ecom.activityRent.RentActivity;
import com.shree.ecom.activityRequestProduct.RequestProductActivity;
import com.shree.ecom.activitySellRegister.view.RegisterSellerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BuySellFragment extends Fragment {

    @BindView(R.id.requestProduct)
    Button requestProductButton;

    @BindView(R.id.sellProduct)
    Button sellProductButton;

    @BindView(R.id.rentProduct)
    Button rentProduct;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buysell, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.rentProduct)
    void onRentProductClicked() {
        startActivity(new Intent(getActivity(), RentActivity.class));
    }

    @OnClick(R.id.requestProduct)
    void onRequestProductClicked() {
        startActivity(new Intent(getActivity(), RequestProductActivity.class));
    }

    @OnClick(R.id.sellProduct)
    void onSellProductClicked() {
        startActivity(new Intent(getActivity(), RegisterSellerActivity.class));
    }


}
