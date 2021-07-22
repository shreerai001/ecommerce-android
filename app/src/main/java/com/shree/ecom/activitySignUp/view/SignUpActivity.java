package com.shree.ecom.activitySignUp.view;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.shree.ecom.R;
import com.shree.ecom.activitySignUp.contract.SignUpContract;

import java.util.logging.Level;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity  {

    @BindView(R.id.next)
    Button NextButton_v;

    @BindView(R.id.relative)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.next)
    public void nextOnClick() {
        startActivity(new Intent(SignUpActivity.this, BasicSignUpActivity.class));
    }

}
