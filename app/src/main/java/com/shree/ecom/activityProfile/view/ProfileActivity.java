package com.shree.ecom.activityProfile.view;

import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shree.ecom.Main2Activity;
import com.shree.ecom.R;
import com.shree.ecom.activityProfile.contract.ProfileContract;
import com.shree.ecom.activityProfile.model.dto.ProfileDataDto;
import com.shree.ecom.activityProfile.model.dto.ProfileShippingDataDto;
import com.shree.ecom.logout.presenter.LogOutPresenter;
import com.shree.ecom.utils.di.App;
import com.shree.ecom.utils.values.CONST;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.View {

    @Inject
    ProfileContract.Presenter presenter;

    @BindView(R.id.logout)
    Button logOutButton_v;

    @BindView(R.id.linear_profile)
    LinearLayout profileLinearLayout;

    @BindView(R.id.address1_text)
    TextView address1_v;

    @BindView(R.id.address2_text)
    TextView address2_v;

    @BindView(R.id.name_text)
    TextView nameTextView_v;

    @BindView(R.id.address_text)
    TextView addressTextView_v;

    @BindView(R.id.phone_text)
    TextView phoneTextView_v;

    @BindView(R.id.city_text)
    TextView cityTextView_v;

    @BindView(R.id.state_text)
    TextView stateTextView_v;

    @BindView(R.id.profile_image)
    ImageView profileImageView_v;

    @BindView(R.id.email_text)
    TextView emailTextView_v;

    @BindView(R.id.country_text)
    TextView countryTextView_v;

    @BindView(R.id.postal_text)
    TextView postalTextView_v;

    @BindView(R.id.lastname_text)
    TextView lastNameTextView_v;

    @BindView(R.id.edit)
    FloatingActionButton editFloatingActionButton_v;

    HashMap<String, String> fields = new HashMap<>();

    BottomSheetBehavior sheetBehavior;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        ((App) getApplicationContext()).getComponent().inject(this);
        presenter.setView(this);
    }

    @OnClick(R.id.edit)
    void onFloatingActionClick() {
        startActivity(new Intent(ProfileActivity.this, ProfileEditActivity.class).putExtra("fields", fields));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadData();
    }

    @Override
    public void loadShippingDetail(ProfileShippingDataDto shippingEntity) {
        phoneTextView_v.setText(shippingEntity.getPhone());
        cityTextView_v.setText(shippingEntity.getCity());
        stateTextView_v.setText(shippingEntity.getState());
        countryTextView_v.setText(shippingEntity.getCountry());
        postalTextView_v.setText(shippingEntity.getPostcode());
        address1_v.setText(shippingEntity.getAddress1());
        address2_v.setText(shippingEntity.getAddress2());
        fields.put("id", String.valueOf(shippingEntity.getId()));
        fields.put("address1", shippingEntity.getAddress1());
        fields.put("address2", shippingEntity.getAddress2());
        fields.put("phone", shippingEntity.getPhone());
        fields.put("city", shippingEntity.getCity());
        fields.put("state", shippingEntity.getState());
        fields.put("country", shippingEntity.getCountry());
        fields.put("postalcode", shippingEntity.getPostcode());
    }

    @Override
    public void loadPresonalDetail(ProfileDataDto profileEntity) {
        nameTextView_v.setText(profileEntity.getFirst_name());
        lastNameTextView_v.setText(profileEntity.getLast_name());
        Picasso.with(getApplicationContext()).load(profileEntity.getImage()).into(profileImageView_v);
        emailTextView_v.setText(profileEntity.getEmail());
        fields.put("firstname", profileEntity.getFirst_name());
        fields.put("lastname", profileEntity.getLast_name());
        fields.put("image", profileEntity.getImage());
        fields.put("email", profileEntity.getEmail());
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(profileLinearLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void displayTransferMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void progressOn(boolean progressState) {

    }

    @Override
    public void stop() {

    }

    @OnClick(R.id.logout)
    void onlogOutClick() {
//        LogOutPresenter logOutPresenter = new LogOutPresenter();
//        logOutPresenter.clearLogged(getApplicationContext());
//        displayTransferMessage(CONST.LOGOUT);
//        startActivity(new Intent(ProfileActivity.this, Main2Activity.class));

        BottomSheetDialogFragment bottomSheetDialogFragment = new BottomSheetDialogFragment();
        bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
    }
}
