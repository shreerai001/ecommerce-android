package com.shree.ecom.activityLogin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.shree.ecom.R;
import com.shree.ecom.activityBrowse.view.activity.UsedEquipmentActivity;
import com.shree.ecom.activityMyCart.MyCartActivity;
import com.shree.ecom.activityPasswordChange.PasswordChangeActivity;
import com.shree.ecom.activitySignUp.view.SignUpActivity;
import com.shree.ecom.activityLogin.contract.LoginContract;
import com.shree.ecom.activityWhishlist.view.WishlistActivity;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.di.BaseActivity;
import com.shree.ecom.utils.values.CONST;
import com.shree.ecom.utils.values.ProgressUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.google_button)
    SignInButton googleSignInButton;

    @BindView(R.id.relative)
    RelativeLayout relativeLayout_v;

    @BindView(R.id.login_button)
    Button loginButton_v;

    @BindView(R.id.username_editext)
    EditText email_v;

    @BindView(R.id.password_editext)
    EditText password_v;

    @BindView(R.id.signup_button)
    Button signUpButton_v;

    @BindView(R.id.forgetPassword_label)
    TextView forgetPasswordLabel_v;

    private static final String TAG = "AndroidClarified";

    private GoogleSignInClient googleSignInClient;

    private ProgressDialog progressDialog;


    @Inject
    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);

        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = googleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 101);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick(R.id.login_button)
    @Override
    public void login() {
        if (email_v.getText().toString().isEmpty()) {
            email_v.setError(CONST.INPUT_NULL_ERROR);
            email_v.requestFocus();
        } else if (password_v.getText().toString().isEmpty()) {
            password_v.setError(CONST.INPUT_NULL_ERROR);
            password_v.requestFocus();
        } else {
            presenter.login(email_v.getText().toString(), password_v.getText().toString());
        }
    }

    @OnClick(R.id.forgetPassword_label)
    public void onPasswordForget() {
        startActivity(new Intent(LoginActivity.this, PasswordChangeActivity.class));
    }

    @OnClick(R.id.signup_button)
    @Override
    public void signUp() {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }

    @Override
    public void loggedIn() {
        startActivity(new Intent(LoginActivity.this, WishlistActivity.class));
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case 101:
                    try {
                        // The Task returned from this call is always completed, no need to attach
                        // a listener.
                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                        GoogleSignInAccount account = task.getResult(ApiException.class);
                        //   Toast.makeText(getApplicationContext(), "" + account, Toast.LENGTH_LONG).show();
                        //onLoggedIn(account);
                    } catch (ApiException e) {
                        // The ApiException status code indicates the detailed failure reason.
                        Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
                    }
                    break;
            }
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(relativeLayout_v, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void displayTransferMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void progressOn(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(LoginActivity.this);
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void stop() {

    }
}
