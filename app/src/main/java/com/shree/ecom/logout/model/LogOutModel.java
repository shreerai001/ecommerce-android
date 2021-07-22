package com.shree.ecom.logout.model;

import android.content.Context;

import com.shree.ecom.logout.contract.LogOutContract;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;

public class LogOutModel implements LogOutContract.Model {

    @Override
    public void clearLogged(Context context) {
        BaseRepositoryIMPL baseRepositoryIMPL = new BaseRepositoryIMPL(context);
        baseRepositoryIMPL.clearLogged();
    }
}
