package com.shree.ecom.activitySignUp.view;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.activitySignUp.contract.SignUpContract;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.CONST;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CredentialSignUpActivity extends AppCompatActivity implements SignUpContract.View {

    @BindView(R.id.relative)
    RelativeLayout relativeLayout;

    @BindView(R.id.email)
    EditText email_v;

    @BindView(R.id.password)
    EditText password_v;

    @BindView(R.id.passwordConfirmation)
    EditText passwordConfirmation_v;

    @BindView(R.id.save)
    Button save_v;

    @Inject
    SignUpContract.Presenter signUpPresenter;

    private String firstName_V;
    private String lastName_V;
    private String phoneNumber_V;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credential_sign_up);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        signUpPresenter.setView(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            firstName_V = bundle.getString("firstName_V");
            lastName_V = bundle.getString("lastName_V");
            phoneNumber_V = bundle.getString("phone_V");
        }
    }

//    @Override
//    public void showMessage(String message) {
//        Snackbar.make(relativeLayout, message, Snackbar.LENGTH_LONG).show();
//    }

    @Override
    public void initView() {

    }

    @Override
    @OnClick(R.id.save)
    public void validate() {
        if (email_v.getText().toString().isEmpty()) {
            email_v.setError(CONST.INPUT_NULL_ERROR);
            email_v.requestFocus();
        } else if (password_v.getText().toString().isEmpty()) {
            password_v.setError(CONST.INPUT_NULL_ERROR);
            password_v.requestFocus();
        } else if (passwordConfirmation_v.getText().toString().isEmpty()) {
            passwordConfirmation_v.setError(CONST.INPUT_NULL_ERROR);
            passwordConfirmation_v.requestFocus();
        } else {
            signUpPresenter.saveUsers(firstName_V, lastName_V, phoneNumber_V, email_v.getText().toString(), password_v.getText().toString()
                    , passwordConfirmation_v.getText().toString());
        }
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(relativeLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void displayTransferMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void progressOn(boolean progessState) {

    }

    @Override
    public void stop() {

    }
}
