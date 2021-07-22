package com.shree.ecom.logout.presenter;

import android.content.Context;

import com.shree.ecom.logout.contract.LogOutContract;
import com.shree.ecom.logout.model.LogOutModel;

import io.reactivex.disposables.Disposable;

public class LogOutPresenter implements LogOutContract.Presenter {

    private LogOutContract.Model model;

    @Override
    public void clearLogged(Context context) {
        model = new LogOutModel();
        model.clearLogged(context);
    }

}
