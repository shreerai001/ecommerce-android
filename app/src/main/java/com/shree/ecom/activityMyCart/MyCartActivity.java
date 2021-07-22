package com.shree.ecom.activityMyCart;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.activityLogin.LoginActivity;
import com.shree.ecom.activityMyCart.contract.MyCartContract;
import com.shree.ecom.activitySignUp.view.SignUpActivity;
import com.shree.ecom.checkout.contract.CheckoutContract;
import com.shree.ecom.checkout.model.dto.Cart;
import com.shree.ecom.checkout.model.dto.CheckoutEntity;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.CONST;
import com.shree.ecom.utils.values.CartEntity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCartActivity extends AppCompatActivity implements
        MyCartContract.View,
        CheckoutContract.View,
        BaseCart {

    @Inject
    MyCartContract.Presenter presenter;

    @Inject
    CheckoutContract.Presenter presenterCheckout;

    @BindView(R.id.mycart_recycler)
    RecyclerView myCartRecycler_v;

    @BindView(R.id.noitem_cart)
    ImageView noItemCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        presenterCheckout.setView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadData();
    }

    @Override
    public void loadData(List<CartEntity> cartEntities) {
        if (cartEntities.size() == 0) {
            noItemCard.setVisibility(View.VISIBLE);
            Snackbar.make(myCartRecycler_v, CONST.NULL_CART, Snackbar.LENGTH_LONG).show();
        }
        MyCartAdapter myCartAdapter = new MyCartAdapter(cartEntities, getApplicationContext(), this);
        myCartRecycler_v.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        myCartRecycler_v.setAdapter(myCartAdapter);
        myCartRecycler_v.setHasFixedSize(true);
    }

    @Override
    public void deleteFromCart(int id) {
        Toast.makeText(getApplicationContext(), "" + id, Toast.LENGTH_LONG).show();
        presenter.deleteFromCart(id);
        presenter.loadData();
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(myCartRecycler_v, message, Snackbar.LENGTH_LONG).show();
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

    @Override
    public void addToCart(Cart cart) {

    }
}
