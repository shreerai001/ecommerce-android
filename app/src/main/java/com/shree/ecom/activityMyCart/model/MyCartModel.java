package com.shree.ecom.activityMyCart.model;

import android.content.Context;

import com.shree.ecom.activityMyCart.contract.MyCartContract;
import com.shree.ecom.utils.mvp.BaseRepository;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;
import com.shree.ecom.utils.values.CartEntity;
import com.shree.ecom.utils.values.DbHelper;

import java.util.List;

public class MyCartModel implements MyCartContract.Model {
    private Context context;
    private DbHelper dbHelper;

    public MyCartModel(Context context) {
        this.context = context;
    }

    @Override
    public List<CartEntity> getCartDetail() {
        dbHelper = new DbHelper(context);
        return dbHelper.getCardInfo();
    }

    @Override
    public List<CartEntity> deleteFromCart(int id) {
        DbHelper dbHelper = new DbHelper(context);
        return dbHelper.deleteItemFromCart(id);
    }


}
