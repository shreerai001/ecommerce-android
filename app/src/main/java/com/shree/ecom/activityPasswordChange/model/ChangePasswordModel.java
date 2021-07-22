package com.shree.ecom.activityPasswordChange.model;

import android.content.Context;

import com.shree.ecom.utils.mvp.BaseRepository;

public class ChangePasswordModel extends BaseRepository {

    public Context context;

    public ChangePasswordModel(Context context) {
        this.context = context;
    }

    public String getToken() {
        return super.accessToken(context);
    }

    @Override
    public boolean checkdLoggedIn() {
        return false;
    }
}
