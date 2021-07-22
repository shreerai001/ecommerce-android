package com.shree.ecom.activityWhishlist.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.activityWhishlist.contract.CancelWishlistContract;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CancelWishlistActivity extends AppCompatActivity implements CancelWishlistContract.View {

    @BindView(R.id.cancel_order_product_imageView)
    ImageView imageViewCancelOrder_v;

    @BindView(R.id.hour_price)
    TextView priceHour_v;

    @Inject
    CancelWishlistContract.Presenter presenter;

    @BindView(R.id.productdetail_order_cancellation)
    LinearLayout productDetail_v;

    @BindView(R.id.cancelWishlist)
    Button cancelOrder_v;
    private String id;
    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_order);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        Intent intent = getIntent();
        String price = intent.getStringExtra("price");
        String pic = intent.getStringExtra("pic");
        id = intent.getStringExtra("id");
        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
        Picasso.with(getApplicationContext()).load(pic).into(imageViewCancelOrder_v);
        priceHour_v.setText(price);
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(productDetail_v, message, Snackbar.LENGTH_LONG).show();
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


    @OnClick(R.id.cancelWishlist)
    public void cancelWishListFromId() {
        try {
            if (id != null) {
                cancelWishList(id);
            } else {
                Toast.makeText(getApplicationContext(), "Id not found", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void cancelWishList(String productId) {
        presenter.cancelWishList(productId);
    }
}
