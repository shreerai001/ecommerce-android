package com.shree.ecom.utils.mvp;

import android.content.Context;
import android.content.SharedPreferences;

import com.shree.ecom.activityBrowse.model.dto.all.AllEquipmentProductDto;
import com.shree.ecom.utils.values.CartEntity;

import java.util.List;

public abstract class BaseRepository {
    protected String accessToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        return sharedPreferences.getString("accessToken", "null");
    }

    public abstract boolean checkdLoggedIn();

}
