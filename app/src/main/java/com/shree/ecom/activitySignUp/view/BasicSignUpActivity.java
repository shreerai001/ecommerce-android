package com.shree.ecom.activitySignUp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.shree.ecom.R;
import com.shree.ecom.utils.values.CONST;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasicSignUpActivity extends AppCompatActivity {

    @BindView(R.id.save)
    Button save;

    @BindView(R.id.relative)
    RelativeLayout relativeLayout;

    @BindView(R.id.firstName)
    EditText firstName_v;

    @BindView(R.id.lastName)
    EditText lastName_v;

    @BindView(R.id.phoneNumber)
    EditText phoneNumber_v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save)
    public void saveOnClick() {
        String firstName_V = null;
        String lastName_V = null;
        String phoneNumber_V = null;
        if (firstName_v.getText().toString().isEmpty()) {
            firstName_v.setError(CONST.INPUT_NULL_ERROR);
            firstName_v.requestFocus();
        } else if (lastName_v.getText().toString().isEmpty()) {
            lastName_v.setError(CONST.INPUT_NULL_ERROR);
            lastName_v.requestFocus();
        } else if (phoneNumber_v.getText().toString().isEmpty()) {
            phoneNumber_v.setError(CONST.INPUT_NULL_ERROR);
            phoneNumber_v.requestFocus();
        } else {
            lastName_V = lastName_v.getText().toString();
            phoneNumber_V = phoneNumber_v.getText().toString();
            Intent intent = new Intent(BasicSignUpActivity.this, CredentialSignUpActivity.class);
            intent.putExtra(firstName_V, firstName_v.getText().toString());
            intent.putExtra(lastName_V, lastName_v.getText().toString());
            intent.putExtra(phoneNumber_V, phoneNumber_v.getText().toString());
            startActivity(new Intent(BasicSignUpActivity.this, CredentialSignUpActivity.class));

        }
    }

}
