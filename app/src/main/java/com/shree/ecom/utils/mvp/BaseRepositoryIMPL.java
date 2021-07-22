package com.shree.ecom.utils.mvp;

import android.content.Context;
import android.content.SharedPreferences;

import com.shree.ecom.utils.values.CartEntity;
import com.shree.ecom.utils.values.DbHelper;

import java.util.List;

public class BaseRepositoryIMPL extends BaseRepository {
    public Context context;

    public BaseRepositoryIMPL(Context context) {
        this.context = context;
    }

    @Override
    public boolean checkdLoggedIn() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("tokenType", "");
        if (token.length() > 1) {
            return true;
        }
        return false;
    }

    public void clearLogged() {
        SharedPreferences preferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        preferences.edit().clear().apply();
    }

    public List<CartEntity> getProduct(int id) {
        DbHelper dbHelper = new DbHelper(context);
        return dbHelper.getCardInfo(id);
    }
}
