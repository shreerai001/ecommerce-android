package com.shree.ecom.activityCartProceed.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shree.ecom.R;
import com.shree.ecom.activityCartProceed.contract.CartProceedContract;
import com.shree.ecom.activityCartProceed.presenter.CartPresenter;
import com.shree.ecom.activityProfile.contract.ProfileContract;
import com.shree.ecom.activityProfile.model.dto.ProfileDataDto;
import com.shree.ecom.activityProfile.model.dto.ProfileShippingDataDto;
import com.shree.ecom.utils.di.App;

import javax.inject.Inject;

public class CartProceedActivity extends AppCompatActivity implements CartProceedContract.View, ProfileContract.View {

    @Inject
    CartProceedContract.Presenter presenter;

    @Inject
    ProfileContract.Presenter profilePresenter;

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        profilePresenter.setView(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_proceed);
        ((App) getApplication()).getComponent().inject(this);
    }

    @Override
    public void proceedCartEntity() {

    }

    @Override
    public void loadShippingDetail(ProfileShippingDataDto shippingEntity) {

    }

    @Override
    public void loadPresonalDetail(ProfileDataDto profileEntity) {

    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void displayTransferMessage(String message) {

    }

    @Override
    public void progressOn(boolean progressState) {

    }

    @Override
    public void stop() {

    }
}
