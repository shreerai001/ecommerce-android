package com.shree.ecom.activityCancelOrders;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.activityCancelOrders.contract.CancelOrderContract;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.CONST;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CancelOrderActivity extends AppCompatActivity implements CancelOrderContract.View {

    @BindView(R.id.cancel_order_product_imageView)
    ImageView imageViewCancelOrder_v;

    @BindView(R.id.hour_price)
    TextView priceHour_v;

    @Inject
    CancelOrderContract.Presenter presenter;

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
        Intent intent = getIntent();
        String price = intent.getStringExtra("month_price");
        String pic = intent.getStringExtra("pic");
        status = intent.getStringExtra("status");
        Toast.makeText(getApplicationContext(), "" + status, Toast.LENGTH_LONG).show();
        id = intent.getStringExtra("id");
        Picasso.with(getApplicationContext()).load(pic).into(imageViewCancelOrder_v);
        priceHour_v.setText(price);
    }

    @OnClick(R.id.cancelWishlist)
    void onCancelButtonClick() {
        if (status.equals("Pending")) {
            cancelOrder(id);
        } else if (status == "Delivered") {
            displayMessage(CONST.PRODUCT_ALREADY_DELIVERED);
        } else {
            displayMessage(CONST.PRODUCT_CANNOT_BE_CANCELLED);
        }
    }

    @Override
    public void cancelOrder(String id) {
        presenter.cancelOrder(id);
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
}
