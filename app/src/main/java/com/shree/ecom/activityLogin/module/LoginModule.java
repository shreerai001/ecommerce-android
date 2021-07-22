package com.shree.ecom.activityLogin.module;

import android.content.Context;

import com.shree.ecom.activityLogin.contract.LoginContract;
import com.shree.ecom.activityLogin.model.LoginModel;
import com.shree.ecom.activityLogin.presenter.LoginPresenter;
import com.shree.ecom.activityLogin.model.repository.LoginRepository;
import com.shree.ecom.activityLogin.model.repository.LoginRepositoryIMPL;
import com.shree.ecom.activityLogin.services.LoginApiServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shree on 14,May,2019
 */
@Module
public class LoginModule {
    @Provides
    public LoginContract.Model provideModel(LoginRepository loginRepository) {
        return new LoginModel(loginRepository);
    }

    @Provides
    public LoginContract.Presenter providePresenter(LoginContract.Model model) {
        return new LoginPresenter(model);
    }

    @Singleton
    @Provides
    public LoginRepository provideRepository(Context context, LoginApiServices loginApiServices) {
        return new LoginRepositoryIMPL(context, loginApiServices);
    }
}
