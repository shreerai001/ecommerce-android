package com.shree.ecom.profile.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shree.ecom.R;
import com.shree.ecom.activityProfile.contract.ProfileContract;
import com.shree.ecom.activityProfile.model.dto.ProfileDataDto;
import com.shree.ecom.activityProfile.model.dto.ProfileShippingDataDto;
import com.shree.ecom.blogs.BlogsAcitvity;
import com.shree.ecom.contacts.AboutUsActivity;
import com.shree.ecom.contacts.activityContactUs.view.ContactUsActivity;
import com.shree.ecom.contacts.activityContacts.ContactActivity;
import com.shree.ecom.contacts.activityPolicy.view.PoliciesActivity;
import com.shree.ecom.utils.di.App;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment implements ProfileContract.View {

    @Inject
    ProfileContract.Presenter presenter;

    @BindView(R.id.profile_image)
    CircleImageView circleImageView;

    @BindView(R.id.profile_name)
    TextView profileName;

    @BindView(R.id.email)
    TextView email_v;

    @BindView(R.id.rel_about)
    RelativeLayout rel_abouts;

    @BindView(R.id.rel_policy)
    RelativeLayout rel_policys;

    @BindView(R.id.rel_contact_us)
    RelativeLayout rel_contact_uss;

    @BindView(R.id.rel_contact)
    RelativeLayout rel_contacts;

    @BindView(R.id.rel_blog)
    RelativeLayout rel_blogs;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, view);
        ((App) getActivity().getApplication()).getComponent().inject(this);
        presenter.setView(this);
        setClickIntent();
        return view;
    }

    void setClickIntent() {

        rel_abouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AboutUsActivity.class);
                startActivity(intent);
            }
        });

        rel_policys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), PoliciesActivity.class);
                startActivity(intent);

            }
        });

        rel_contact_uss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), ContactUsActivity.class);
                startActivity(intent);

            }
        });

        rel_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), ContactActivity.class);
                startActivity(intent);

            }
        });

        rel_blogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), BlogsAcitvity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadData();
    }

    @Override
    public void loadShippingDetail(ProfileShippingDataDto shippingEntity) {

    }

    @Override
    public void loadPresonalDetail(ProfileDataDto profileEntity) {
        Picasso.with(getContext()).load(profileEntity.getImage()).into(circleImageView);
        profileName.setText(profileEntity.getFirst_name() + " " + profileEntity.getLast_name());
        email_v.setText(profileEntity.getEmail());
    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void displayTransferMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void progressOn(boolean progressState) {

    }

    @Override
    public void stop() {

    }
}
