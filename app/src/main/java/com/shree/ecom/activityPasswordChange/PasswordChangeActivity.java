package com.shree.ecom.activityPasswordChange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.activityPasswordChange.model.ChangePasswordModel;
import com.shree.ecom.activityPasswordChange.service.ApiManager;
import com.shree.ecom.activityPasswordChange.service.ChangePasswordApiService;
import com.shree.ecom.utils.values.BaseResponseEntity;
import com.shree.ecom.utils.values.CONST;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasswordChangeActivity extends AppCompatActivity {

    @BindView(R.id.currentPassword)
    EditText password_v;

    @BindView(R.id.passwordOne)
    EditText passwordOne_v;

    @BindView(R.id.passwordTwo)
    EditText passwordTwo_v;

    @BindView(R.id.confirm)
    Button confirmButton_v;

    @BindView(R.id.progressChangePassword)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.confirm)
    void onConfirmClick() {
        if (password_v.getText().toString().isEmpty()) {
            password_v.setError(CONST.INPUT_NULL_ERROR);
            password_v.requestFocus();
        }
        if (passwordOne_v.getText().toString().isEmpty()) {
            passwordOne_v.setError(CONST.INPUT_NULL_ERROR);
            passwordOne_v.requestFocus();
        } else if (passwordTwo_v.getText().toString().isEmpty()) {
            passwordTwo_v.setError(CONST.INPUT_NULL_ERROR);
            passwordTwo_v.requestFocus();
        }
//        else if (passwordOne_v.getText().toString() != passwordTwo_v.getText().toString()) {
//            passwordOne_v.setError(CONST.FIELD_UNMATCHED_ERROR);
//            passwordOne_v.requestFocus();
//        }
        else {
            progressBar.setVisibility(View.VISIBLE);
            ChangePasswordModel changePasswordModel = new ChangePasswordModel(getApplicationContext());
            ChangePasswordApiService changePasswordApiService = ApiManager.getAPIService();
            changePasswordApiService.changePassword("Bearer " + changePasswordModel.getToken(), password_v.getText().toString(),
                    passwordOne_v.getText().toString(),
                    passwordTwo_v.getText().toString())
                    .enqueue(new Callback<BaseResponseEntity>() {
                        @Override
                        public void onResponse(Call<BaseResponseEntity> call, Response<BaseResponseEntity> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "" + response.message(), Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                            } else {
                                Toast.makeText(getApplicationContext(), "" + response.errorBody(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<BaseResponseEntity> call, Throwable t) {

                        }
                    });
        }

    }

}
