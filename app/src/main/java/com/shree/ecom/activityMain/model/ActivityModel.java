package com.shree.ecom.activityMain.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.shree.ecom.activityMain.contract.ActivityMainContract;
import com.shree.ecom.activityMain.model.repositories.ActivityMainRepository;
import com.shree.ecom.utils.mvp.BaseRepositoryIMPL;

public class ActivityModel extends BaseRepositoryIMPL implements ActivityMainContract.Model {
    private Context context;
    private ActivityMainRepository activityMainRepository;

    public ActivityModel(Context context, ActivityMainRepository activityMainRepository) {
        super(context);
        this.context = context;
        this.activityMainRepository = activityMainRepository;
    }

    @Override
    public boolean checkedLogged() {
        return super.checkdLoggedIn();
    }
}
