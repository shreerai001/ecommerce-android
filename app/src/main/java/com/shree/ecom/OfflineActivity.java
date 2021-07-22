package com.shree.ecom;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.shree.ecom.utils.values.CONST;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OfflineActivity extends AppCompatActivity {

    @BindView(R.id.linearLayout)
    RelativeLayout linearLayout_v;

    @BindView(R.id.tryInternet)
    Button internetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        ButterKnife.bind(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        displayMessage();
    }

    void displayMessage() {
        Toast.makeText(getApplicationContext(), CONST.OFFLINE, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.tryInternet)
    void onInternetButtonClick() {
        if (isNetworkConnected()) {
            startActivity(new Intent(OfflineActivity.this, Main2Activity.class));
        } else {
            displayMessage();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
