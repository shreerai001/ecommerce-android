package com.shree.ecom.activityProfile.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.activityPasswordChange.service.ApiManager;
import com.shree.ecom.activityPasswordChange.service.ChangePasswordApiService;
import com.shree.ecom.activityProfile.contract.ProfileContract;
import com.shree.ecom.activityProfile.model.ProfileActivityModel;
import com.shree.ecom.activityProfile.model.dto.ProfileDataDto;
import com.shree.ecom.activityProfile.model.dto.ProfileShippingDataDto;
import com.shree.ecom.activityProfile.services.ProfileApiManager;
import com.shree.ecom.activityProfile.services.ProfileApiService;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.BaseResponseEntity;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileEditActivity extends AppCompatActivity {


    @BindView(R.id.linear_profile)
    LinearLayout profileLinearLayout;

    @BindView(R.id.address1_text)
    EditText address1_v;

    @BindView(R.id.address2_text)
    EditText address2_v;

    @BindView(R.id.name_text)
    EditText nameTextView_v;

    @BindView(R.id.address_text)
    EditText addressTextView_v;

    @BindView(R.id.phone_text)
    EditText phoneTextView_v;

    @BindView(R.id.city_text)
    EditText cityTextView_v;

    @BindView(R.id.state_text)
    EditText stateTextView_v;

    @BindView(R.id.profile_image)
    ImageView profileImageView_v;

    @BindView(R.id.email_text)
    EditText emailTextView_v;

    @BindView(R.id.country_text)
    EditText countryTextView_v;

    @BindView(R.id.postal_text)
    EditText postalTextView_v;

    @BindView(R.id.lastname_text)
    EditText lastNameTextView_v;

    @BindView(R.id.save)
    Button saveButton_v;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        HashMap<String, String> fields = (HashMap<String, String>) intent.getSerializableExtra("fields");
        init(fields);
    }

    void init(HashMap<String, String> fields) {
        id = fields.get("id");
        addressTextView_v.setText(fields.get("address1"));
        phoneTextView_v.setText(fields.get("phone"));
        cityTextView_v.setText(fields.get("city"));
        stateTextView_v.setText(fields.get("state"));
        countryTextView_v.setText(fields.get("country"));
        postalTextView_v.setText(fields.get("postalcode"));
        address1_v.setText(fields.get("address1"));
        address2_v.setText(fields.get("address2"));
        emailTextView_v.setText(fields.get("email"));
        nameTextView_v.setText(fields.get("firstname"));
        lastNameTextView_v.setText(fields.get("lastname"));
        Picasso.with(getApplicationContext()).load(fields.get("image")).into(profileImageView_v);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @OnClick(R.id.save)
    void onEditClick() {
        ProfileApiService profileApiService = ProfileApiManager.getAPIService();
        ProfileActivityModel profileActivityModel = new ProfileActivityModel();
        profileApiService.changeDetail("Bearer " + profileActivityModel.getToken(getApplicationContext()),
                id,
                nameTextView_v.getText().toString(),
                lastNameTextView_v.getText().toString(),
                emailTextView_v.getText().toString(),
                phoneTextView_v.getText().toString(),
                address1_v.getText().toString(),
                address2_v.getText().toString(),
                cityTextView_v.getText().toString(),
                stateTextView_v.getText().toString(),
                countryTextView_v.getText().toString(),
                postalTextView_v.getText().toString())
                .enqueue(new Callback<BaseResponseEntity>() {
                    @Override
                    public void onResponse(Call<BaseResponseEntity> call, Response<BaseResponseEntity> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Changed Sucessfully", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(ProfileEditActivity.this, ProfileActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "" + response.errorBody(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseEntity> call, Throwable t) {

                    }
                });
    }
}
