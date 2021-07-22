package com.shree.ecom.activitySignUp.module;

import com.shree.ecom.activitySignUp.contract.SignUpContract;
import com.shree.ecom.activitySignUp.model.SignUpModel;
import com.shree.ecom.activitySignUp.presenter.SignUpPresenter;
import com.shree.ecom.activitySignUp.model.repositories.SignUpRepository;
import com.shree.ecom.activitySignUp.model.repositories.SignUpRepositoryIMPL;
import com.shree.ecom.activitySignUp.services.api.SignUpApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shree on 14,May,2019
 */
@Module
public class SignUpModule {

    @Provides
    public SignUpContract.Presenter providePresenter(SignUpContract.Model model) {
        return new SignUpPresenter(model);
    }

    @Provides
    public SignUpContract.Model provideModel(SignUpRepository signUpRepository) {
        return new SignUpModel(signUpRepository);
    }

    @Singleton
    @Provides
    public SignUpRepository provideSignUpRepo(SignUpApiService signUpApiService) {
        return new SignUpRepositoryIMPL(signUpApiService);
    }

}
