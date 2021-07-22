package com.shree.ecom.contacts.activityContacts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.shree.ecom.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactActivity extends AppCompatActivity {

    @BindView(R.id.facebook_url)
    TextView facebookUrl_v;

    @BindView(R.id.twitter_url)
    TextView twitterUrl_v;

    @BindView(R.id.insta_url)
    TextView instaUrl_v;

    @BindView(R.id.linkden_url)
    TextView linkdenUrl_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);
        init();
    }

    void init() {
        facebookUrl_v.setPaintFlags(facebookUrl_v.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        twitterUrl_v.setPaintFlags(twitterUrl_v.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        instaUrl_v.setPaintFlags(instaUrl_v.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        linkdenUrl_v.setPaintFlags(linkdenUrl_v.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    @OnClick(R.id.facebook_url)
    void onFacebookClick() {
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = getFacebookPageURL(getApplicationContext());
        facebookIntent.setData(Uri.parse(facebookUrl));
        startActivity(facebookIntent);
    }

    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) {
                return "fb://facewebmodal/f?href=" + "https://www.facebook.com/shreeraidotcom";
            } else {
                return "fb://page/" + "https://www.facebook.com/shreeraidotcom";
            }
        } catch (PackageManager.NameNotFoundException e) {
            return "https://www.facebook.com/shreeraidotcom";
        }
    }
}
